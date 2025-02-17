package com.alacriti.HealthCare.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;


import com.alacriti.HealthCare.Entity.Users;

import com.alacriti.HealthCare.Repository.UserRepository;
import com.alacriti.HealthCare.exception.CustomException;

@Service
public class UserService {
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	@Autowired
	private UserRepository userRepo;


	public Users addUser(String email, String name, String role) {
		logger.info("Adding user details into db");
		Users user = new Users();
		try {
			user.setName(name);
			user.setEmail(email);
			user.setRole(role);
			userRepo.save(user);
			logger.info("User details added successfully");
		} catch (DataIntegrityViolationException e) {
			logger.error(e.getMessage());
			return null;
		}
		return user;
	}

	

	public Users getUser(OidcUser principal) {
		logger.info("Fetch logged in user details");
		return userRepo.findByEmail(principal.getEmail().toString());
	}

	public Users findUserByEmail(String email) {
		logger.info("Fetch user into by given email");
		Users user = userRepo.findByEmail(email);
		return user;
	}
	
	public Users findUserById(int id) {
		logger.info("Fetch user into based on given id");
		return userRepo.findById(id);
	}
	
	public Users updateName(String name, String email) {
		try {
			Users user = userRepo.findByEmail(email);
			if(user == null) {
				throw new CustomException("User not found!");
			}
			user.setName(name);
			return userRepo.save(user);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage());
			return null;
		}
	}
	
}
