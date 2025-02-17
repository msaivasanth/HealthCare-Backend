package com.alacriti.HealthCare.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alacriti.HealthCare.DTO.DoctorDTO;
import com.alacriti.HealthCare.DTO.FilterDoctorDTO;
import com.alacriti.HealthCare.Entity.Doctors;
import com.alacriti.HealthCare.Service.DoctorService;


@RestController
@RequestMapping("/api/doctor")
public class DoctorController {
	
	@Autowired
	private DoctorService docService;
	
	@PostMapping("save-user")
	public ResponseEntity<Object> updateDetails(@RequestBody DoctorDTO details, @AuthenticationPrincipal OidcUser user) {
		Object result = docService.addDoctor(details, user);
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("details")
	public ResponseEntity<Object> getDoctorDetails(@AuthenticationPrincipal OidcUser user) {
		Object result = docService.getDoctorDetails(user);
		return ResponseEntity.ok(result);
	}
	
	@PostMapping("find")
	public ResponseEntity<List<Doctors>> findDoctors(@RequestBody FilterDoctorDTO details) {
		List<Doctors> result = docService.findDoctors(details);
		return ResponseEntity.ok(result);
	}
	
	@PutMapping("update-user")
	public ResponseEntity<Object> updateUser(@RequestBody DoctorDTO details, @AuthenticationPrincipal OidcUser user) {
		Object result = docService.updateDetails(details, user);
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("get-doctors/{name}")
	public ResponseEntity<List<Doctors>> findDoctorsByName(@PathVariable("name") String name) {
		List<Doctors> result = docService.findDoctosbyName(name);
		return ResponseEntity.ok(result);
	}
	
}
