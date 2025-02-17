package com.alacriti.HealthCare.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alacriti.HealthCare.DTO.ReviewsDTO;
import com.alacriti.HealthCare.Entity.Reviews;
import com.alacriti.HealthCare.Service.ReviewsService;

@RestController
@RequestMapping("/api/reviews")
public class ReviewsController {

	@Autowired
	private ReviewsService service;
	
	@PostMapping("add-review")
	public ResponseEntity<Reviews> addReview(@RequestBody ReviewsDTO details) {
		Reviews result = service.addReview(details);
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("get-doctor-reviews/{id}")
	public ResponseEntity<List<Reviews>> getReviewsOfDoctor(@PathVariable("id") int id) {
		List<Reviews> result = service.getByDoctorId(id);
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("get-patient-reviews/{id}")
	public ResponseEntity<List<Reviews>> getReviewsByPatients(@PathVariable("id") int id) {
		List<Reviews> result = service.getByPatientId(id);
		return ResponseEntity.ok(result);
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deleteReview(@PathVariable("id") int id) {
		service.deleteReview(id);
		return ResponseEntity.ok("Review deleted successfully!!!");
	}
}
