package com.alacriti.HealthCare.Service;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;

import org.springframework.stereotype.Service;

import com.alacriti.HealthCare.DTO.AppointmentDTO;
import com.alacriti.HealthCare.Entity.Appointments;
import com.alacriti.HealthCare.Entity.Doctors;
import com.alacriti.HealthCare.Entity.Patients;
import com.alacriti.HealthCare.Entity.Users;
import com.alacriti.HealthCare.Repository.AppointmentsRepository;
import com.alacriti.HealthCare.exception.CustomException;

import net.minidev.json.JSONObject;

@Service
public class AppointmentsService {
	private static final Logger logger = LoggerFactory.getLogger(AppointmentsService.class);
	@Autowired
	private AppointmentsRepository repo;

	@Autowired
	private DoctorService docService;

	@Autowired
	private UserService userService;
	
	@Autowired
	private PatientService patService;
	
	private EmailService service1;

	public AppointmentsService(EmailService service) {
		this.service1 = service;
	}

	public Appointments addAppointment(AppointmentDTO details) {
		try {
			logger.info("Appointment details received");
			
			String html = loadTemplate("static/index.html");
			String html2 = loadTemplate("static/doctorEmail.html");
			
			Appointments appointment = new Appointments();
			BeanUtils.copyProperties(details, appointment);
			appointment.setStatus("Scheduled");
			Users user = userService.findUserById(appointment.getDoctorId());
			Users patUser = userService.findUserById(appointment.getPatientId());
			Doctors doc = docService.getDoctorDetails1(user);
			Patients patient = patService.getPatientDetails1(patUser);
			service1.sendEmail(details.getToEmail(), "Health Care Appointments",
					String.format(html, user.getName(), appointment.getDate(), appointment.getTime(), doc.getSpecialitiy(),
							appointment.getType(), doc.getClinic_name(), doc.getAddress()));
			System.out.println("Email to doctor");
			service1.sendEmail(doc.getUser().getEmail(), "Health Care Appointments", String.format(html2, doc.getUser().getName(), details.getDate(), details.getTime(), patient.getUser().getName(), details.getType(), details.getDate(), details.getTime()));
			
			logger.info("Appointment details saved successfully");
			return repo.save(appointment);
			
		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage());
			return new Appointments();
		}
	}

	private String loadTemplate(String templatePath) {
		try {
			ClassPathResource resource = new ClassPathResource(templatePath);
			InputStream inputStream= resource.getInputStream();
			
			return new String(inputStream.readAllBytes());
		} catch (Exception e) {
			throw new RuntimeException("Error loading template" + e);
		}
		
	}
	public List<Appointments> getAppointmentsByDate(String date, int docId) {
		logger.info("Fetching appointments by given date and doctor id");
		return repo.findByDateAndDoctorId(date, docId);
	}

	public List<Appointments> getByPatientId(int id) {
		logger.info("Fetching appointments by given patient id");
		return repo.findByPatientId(id);
	}

	public List<Appointments> getByDoctorId(int id) {
		logger.info("Fetching appointments by given doctor id");
		return repo.findByDoctorId(id);
	}

	public void deleteAppointment(int id) {
		Appointments appointment = repo.findById(id);
		Users doctor = userService.findUserById(appointment.getDoctorId());
		Users patient = userService.findUserById(appointment.getPatientId());
		try {
			service1.sendEmail(doctor.getEmail(), "Health Care Appointments", String.format("Your appointment on %s at %s has been cancelled", appointment.getDate(), appointment.getTime()));
			service1.sendEmail(patient.getEmail(), "Health Care Appointments", String.format("Your appointment on %s at %s has been cancelled, Your appointment fees will be refunded within 24hrs", appointment.getDate(), appointment.getTime()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		repo.delete(appointment);
	}

	public Object setStatus(int id, String status) {
		JSONObject res = new JSONObject();
		try {
			Appointments appointment = repo.findById(id);
			if(appointment == null) {
				throw new CustomException("Appointment not found!");
			}
			appointment.setStatus(status);
			repo.save(appointment);
			System.out.print(appointment.getStatus());
			res.appendField("msg", "status updated successfully!");
			return res;
		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage());
			res.appendField("error", e.getMessage());
			return res;
		}
	}

	public List<Appointments> getAppointments(int id) {
		Date date = new Date();

		SimpleDateFormat fr0 = new SimpleDateFormat("MM.dd.yyyy");
		String str = fr0.format(date);
		String resStr = str;
		System.out.println(fr0.format(date));
		System.out.println("today: " + resStr);
		return repo.findByDate(resStr, id);
	}
	
	public List<Appointments> getAllAppointments() {
		Date date = new Date();

		SimpleDateFormat fr0 = new SimpleDateFormat("MM.dd.yyyy");
		String str = fr0.format(date);
		String resStr = str;
		return repo.findByDate1(resStr);
	}
	
	public List<Appointments> getPatientAppointments(int id) {
		Date date = new Date();

		SimpleDateFormat fr0 = new SimpleDateFormat("MM.dd.yyyy");
		String str = fr0.format(date);
		String resStr = str;
		System.out.println(fr0.format(date));
//		System.out.println(resStr);
		return repo.findByDateForPatient(resStr, id);
	}
}
