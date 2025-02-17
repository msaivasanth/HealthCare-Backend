package com.alacriti.HealthCare.Service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;

import com.alacriti.HealthCare.DTO.DoctorDTO;
import com.alacriti.HealthCare.DTO.FilterDoctorDTO;
import com.alacriti.HealthCare.Entity.Doctors;
import com.alacriti.HealthCare.Entity.Users;
import com.alacriti.HealthCare.Repository.DoctorRepository;
import com.alacriti.HealthCare.Repository.UserRepository;
import com.alacriti.HealthCare.exception.CustomException;

import net.minidev.json.JSONObject;

@Service
public class DoctorService {
	private static final Logger logger = LoggerFactory.getLogger(DoctorService.class);

	@Autowired
	private DoctorRepository repo;

	@Autowired
	private UserRepository userRepo;

	public Object addDoctor(DoctorDTO details, OidcUser user1) {
		JSONObject res = new JSONObject();
		try {
			logger.info("Inside addDoctor service");
			
			Doctors doctor = new Doctors();
			Users user = userRepo.findByEmail(user1.getEmail());
			if (user != null) {
				doctor.setUser(user);
				BeanUtils.copyProperties(details, doctor);
			}
			else {
				throw new CustomException("Doctor not found");
			}
			logger.info("Doctor details saved sucessfully");
			res.appendField("msg", "Doctor added successfully!");
			return res;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			res.appendField("error", e.getMessage());
			return res;
		}
	}

	public Object getDoctorDetails(OidcUser user1) {
		logger.info("Get Doctor Details by OidcUser");
		JSONObject obj = new JSONObject();
		try {
			Users user = userRepo.findByEmail(user1.getEmail());
			if (user != null) {
				Doctors doc = repo.findByUser(user);
				obj.appendField("doctor", doc);

			}
			else { throw new CustomException("Doctor not found"); }
			logger.info("Doctor details fetched successfully!");
			return obj;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			obj.appendField("msg", e.getMessage());
			return obj;
		}
	}

	public List<Doctors> findDoctors(FilterDoctorDTO doctorDTO) {
		logger.info("Getting list of doctors");
		List<Doctors> doct = new ArrayList<>();
		System.out.println(doctorDTO.toString());
		if(doctorDTO.getCity().equals("") || doctorDTO.getSpec().equals("") || doctorDTO.getState().equals("")) {
			doct = repo.findByCityOrStateOrSpecialitiy(doctorDTO.getCity(), doctorDTO.getState(), doctorDTO.getSpec());			
		}
		else {
			doct = repo.findByCityAndStateAndSpecialitiy(doctorDTO.getCity(), doctorDTO.getState(), doctorDTO.getSpec());
		}
		System.out.println(doct);
		logger.info("List of doctors fetched successfully");
		return doct;

	}
	
	public Doctors getDoctorDetails1(Users user) {
		try {
			logger.info("Get Doctor Details by user entity");
			return repo.findByUser(user);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage());
			return null;
		}
		
	}
	
	public Object updateDetails(DoctorDTO details, OidcUser user1) {
		JSONObject res = new JSONObject();
		try {
			logger.info("Updating doctor details");
			Users user = userRepo.findByEmail(user1.getEmail());
			if(user == null) {
				throw new CustomException("User not found");
			}
			Doctors doc = getDoctorDetails1(user);
			BeanUtils.copyProperties(details, doc);
			logger.info("Updated doctor details");
			res.appendField("msg", "Doctor details updated successfully!");
			return res;
		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage());
			res.appendField("error", e.getMessage());
			return res;
		}
		
	}
	
	public List<Doctors> findDoctosbyName(String name) {
		try {
			logger.info("Search doctors by name");
			List<Users> users = userRepo.findByName(name);
			System.out.println(users);
			List<Doctors> doctors = new ArrayList<>();
			for(Users user: users) {
				System.out.println(user.toString());
				Doctors doc = repo.findByUser(user);
				doctors.add(doc);
			}
			return doctors;
		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage());
			return null;
		}
		
	}
};