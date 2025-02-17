package com.alacriti.HealthCare.Service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alacriti.HealthCare.DTO.ReviewsDTO;
import com.alacriti.HealthCare.Entity.Reviews;
import com.alacriti.HealthCare.Repository.ReviewsRepository;
import com.alacriti.HealthCare.exception.CustomException;

@Service
public class ReviewsService {
	private static final Logger logger = LoggerFactory.getLogger(ReviewsService.class);
	@Autowired
	private ReviewsRepository repo;
	
	public Reviews addReview(ReviewsDTO review) {
		try {
			logger.info("Adding review...");
			Reviews org = new Reviews();
			Reviews rev = repo.findByDoctorIdAndPatientId(review.getDoctorId(), review.getPatientId());
			if(rev != null) { throw new CustomException("Review not found!");}
			BeanUtils.copyProperties(review, org);
			logger.info("Review Added Successfully");
			return repo.save(org);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage());
			return null;
		}
	}
	
	public List<Reviews> getByDoctorId(int id) {
		try {
			logger.info("Get review related to doctor based on id");
			List<Reviews> res = repo.findByDoctorId(id);			
			return res;
		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage());
			return null;
		}
	}
	
	public List<Reviews> getByPatientId(int id) {
		logger.info("Get Patient reviews");
		return repo.findByPatientId(id);
	}
	
	public void deleteReview(int id) {
		try {
			logger.info("delete the review");
			Reviews review = repo.findById(id);
			if(review == null) throw new CustomException("Review not found to delete!");
			repo.delete(review);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage());
		}
	}
}
