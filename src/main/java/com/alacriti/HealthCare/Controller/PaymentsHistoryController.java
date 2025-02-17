package com.alacriti.HealthCare.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alacriti.HealthCare.DTO.PaymentsHistoryDTO;
import com.alacriti.HealthCare.Service.PaymentsHistoryService;

@RestController
@RequestMapping("/api/payment")
public class PaymentsHistoryController {
	
	@Autowired
	public PaymentsHistoryService service;
	
	
	@PostMapping("make-payment")
	public ResponseEntity<Object> makePayment(@RequestBody PaymentsHistoryDTO details) {
		Object result = service.makePayment(details);
		return ResponseEntity.ok(result);
	}
}
