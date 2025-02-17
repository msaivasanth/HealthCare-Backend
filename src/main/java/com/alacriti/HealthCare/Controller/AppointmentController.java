package com.alacriti.HealthCare.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.alacriti.HealthCare.DTO.AppointmentDTO;
import com.alacriti.HealthCare.Entity.Appointments;
import com.alacriti.HealthCare.Service.AppointmentsService;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {
	@Autowired
	private AppointmentsService service;
	
	@PostMapping("save")
	public ResponseEntity<Appointments> addAppointment(@RequestBody AppointmentDTO details) {
		Appointments result = service.addAppointment(details);
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("get-slots/{date}/{docId}")
	public ResponseEntity<List<Appointments>> getByDate(@PathVariable("date") String date, @PathVariable("docId") int docId) {
		System.out.println(date + " " + docId);
		List<Appointments> lis = service.getAppointmentsByDate(date, docId);
		return ResponseEntity.ok(lis);
	}
	
	
	@GetMapping("patient/{patId}") 
	public ResponseEntity<List<Appointments>> getByPatient(@PathVariable("patId") int patId) {
		List<Appointments> result = service.getByPatientId(patId);
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("doctor/{docId}")
	public ResponseEntity<List<Appointments>> getByDocotor(@PathVariable("docId") int docId) {
		List<Appointments> result = service.getByDoctorId(docId);
		return ResponseEntity.ok(result);
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deleteAppointment(@PathVariable("id") int id) {
		service.deleteAppointment(id);
		return ResponseEntity.ok("Appointment deleted successfully");
	}
	
	@PutMapping("update-status/{id}/{status}")
	public ResponseEntity<Object> updateAppointmentStatus(@PathVariable("id") int id, @PathVariable("status") String status) {
		Object result = service.setStatus(id, status);
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("todayAppointments/{id}")
	public  ResponseEntity<List<Appointments>>  getAppointments(@PathVariable("id") int id) {
		List<Appointments> result = service.getAppointments(id);
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("patienttodayAppointments/{id}")
	public ResponseEntity<List<Appointments>> getPatientAppointments(@PathVariable("id") int id) {
		List<Appointments> result = service.getPatientAppointments(id);
		return ResponseEntity.ok(result);
	}
}
