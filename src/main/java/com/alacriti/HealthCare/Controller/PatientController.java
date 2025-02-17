package com.alacriti.HealthCare.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alacriti.HealthCare.DTO.PatientDTO;
import com.alacriti.HealthCare.Service.PatientService;

@RestController
@RequestMapping("/api/patient")
public class PatientController {
	
	@Autowired
	private PatientService service;
	@PostMapping("save-user")
	public ResponseEntity<Object> addDetails(@RequestBody PatientDTO details, @AuthenticationPrincipal OidcUser user) {
		Object result = service.addPatient(details, user);
		
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("details")
	public ResponseEntity<Object> getPatientDetails(@AuthenticationPrincipal OidcUser user) {
		Object result = service.getPatientDetails(user);
		return ResponseEntity.ok(result);
	}
	
	@PutMapping("update-user")
	public ResponseEntity<Object> updateDetails(@RequestBody PatientDTO details, @AuthenticationPrincipal OidcUser user) {
		Object result = service.updateDetails(details, user);
		return ResponseEntity.ok(result);
	}
}
