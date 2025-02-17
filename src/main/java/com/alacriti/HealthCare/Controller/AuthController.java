package com.alacriti.HealthCare.Controller;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.alacriti.HealthCare.Entity.Doctors;
import com.alacriti.HealthCare.Entity.Patients;
import com.alacriti.HealthCare.Entity.Users;
import com.alacriti.HealthCare.Service.DoctorService;
import com.alacriti.HealthCare.Service.PatientService;
import com.alacriti.HealthCare.Service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import net.minidev.json.JSONObject;

@RestController
@RequestMapping("/api")
public class AuthController {

	@Autowired
	private UserService service;
	
	@Autowired
	private DoctorService docService;
	
	@Autowired
	private PatientService patService;

	@GetMapping("user-info")
	public ResponseEntity<Users> userDetails(@AuthenticationPrincipal OidcUser principal, HttpServletRequest session) {
		Users user = service.getUser(principal);
		return ResponseEntity.ok(user);

	}

	@GetMapping("login-as/{role}")
	public void loginAs(@PathVariable String role, HttpServletResponse httpServletResponse, HttpServletRequest request)
			throws IOException {
		System.out.println(role);
		HttpSession session = request.getSession();
		session.setAttribute("role", role);
		System.out.println("role " + role + " " + session.getAttribute("role"));

		httpServletResponse.sendRedirect("http://localhost:8080/oauth2/authorization/google");
	}

	@GetMapping("/status")
	public ResponseEntity<Object>getStatus(HttpSession session, HttpServletRequest request,@AuthenticationPrincipal OidcUser oidcUser) {

		JSONObject obj = new JSONObject();
		try {

			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Users	user= service.findUserByEmail(oidcUser.getAttribute("email").toString());
			System.out.println("Role status: " + user.getRole() + " " + session.getAttribute("role"));

			if (session != null && authentication != null && authentication.isAuthenticated()

					&& !(authentication instanceof AnonymousAuthenticationToken)&& user.getRole().equals(session.getAttribute("role")) ) {
		
				
				System.out.println("hi true");
				obj.appendField("role", session.getAttribute("role").toString());
				obj.appendField("status", true);
				return ResponseEntity.ok(obj);
			} else {
				System.out.println("false you");
				obj.appendField("status", false);

				return ResponseEntity.ok(obj);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			obj.appendField("status", false);

			return ResponseEntity.ok(obj);
			
		}
	}

	@PostMapping("/logout")
	public ResponseEntity<Void> LogoutUser(HttpSession session) {

		if (session != null) {

			session.invalidate();
		}
		SecurityContextHolder.clearContext();

		return ResponseEntity.ok().build();

	}
	
	@GetMapping("get-details/{id}") 
	public ResponseEntity<Object> getDetails(@PathVariable("id") int id) {
		JSONObject obj = new JSONObject();
		Users user = service.findUserById(id);
		if(user.getRole().equals("doctor" )) {
			Doctors doc = docService.getDoctorDetails1(user);
			obj.appendField("user", user);
			obj.appendField("docter", doc);			
		}
		if(user.getRole().equals("patient" )) {
			Patients pat = patService.getPatientDetails1(user);
			obj.appendField("user", user);
			obj.appendField("patient", pat);
		}
		System.out.println(obj);
		return ResponseEntity.ok(obj);
	}
	
	
	@PutMapping("edit/{name}")
	public ResponseEntity<Users> updateName(@PathVariable("name") String name, @AuthenticationPrincipal OidcUser principal) {
		Users result = service.updateName(name, principal.getEmail());
		return ResponseEntity.ok(result);
	}
}
