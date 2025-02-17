package com.alacriti.HealthCare.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;

import com.alacriti.HealthCare.DTO.PatientDTO;
import com.alacriti.HealthCare.Entity.Patients;
import com.alacriti.HealthCare.Entity.Users;
import com.alacriti.HealthCare.Repository.PatientRepository;
import com.alacriti.HealthCare.Repository.UserRepository;
import com.alacriti.HealthCare.exception.CustomException;

import net.minidev.json.JSONObject;

@Service
public class PatientService {
	private static final Logger logger = LoggerFactory.getLogger(PatientService.class);
	@Autowired
	private PatientRepository repo;
	
	@Autowired
	private UserRepository userRepo; 
	
	public Object addPatient(PatientDTO details, OidcUser user1) {
		JSONObject res = new JSONObject();
		try {
			logger.info("Adding patient details into db");
			Patients patient = new Patients();
			Users user = userRepo.findByEmail(user1.getEmail());
			if (user != null) {
				patient.setUser(user);
				BeanUtils.copyProperties(details, patient);
			}
			else throw new CustomException("User not found!");
			logger.info("Patient details added successfully");
			res.appendField("msg", "Patient added successfully!");
			return res;
		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage());
			res.appendField("error", e.getMessage());
			return null;
		}
	}
	
	public Object getPatientDetails(OidcUser user1) {
		JSONObject obj = new JSONObject();
		try {
			logger.info("Fetching logged in patient details");
			Users user = userRepo.findByEmail(user1.getEmail());
			if (user != null) {
				Patients doc = repo.findByUser(user);
				obj.appendField("patient", doc);
				
			}
			else throw new CustomException("User not found!");
			return obj;
		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage());
			obj.appendField("error", e.getMessage());
			return obj;
		}
	}
	
	public Patients getPatientDetails1(Users user) {
		logger.info("Fetching patient details by given user entity");
		return repo.findByUser(user);
	}
	
	public Object updateDetails(PatientDTO details, OidcUser user1) {
		JSONObject res = new JSONObject();
		try {
			logger.info("Updating user details");
			Users user = userRepo.findByEmail(user1.getEmail());
			Patients patient = getPatientDetails1(user);
			BeanUtils.copyProperties(details, patient);
			logger.info("Updated user details");
			res.appendField("msg", "Details Updated Successfully!");
			return res;
		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage());
			res.appendField("error", e.getMessage());
			return res;
		}
	}
	
	public Patients getPatientDetailsById(int id) {
		try {
			logger.info("Getting patient details by Id");
			Patients result = repo.findById(id);
			if(result == null) throw new CustomException("Patient not found!");
			logger.info("Patient details fetched successfully!");
			return result;
		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage());
			return null;
		}
	}
}
