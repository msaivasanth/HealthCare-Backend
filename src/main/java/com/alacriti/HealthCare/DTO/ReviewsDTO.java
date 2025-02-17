package com.alacriti.HealthCare.DTO;

public class ReviewsDTO {
	private int rating;
	private String review;
	private int doctorId;
	private int patientId;
	
	public ReviewsDTO() {}

	public ReviewsDTO(int rating, String review, int doctorId, int patientId) {
		super();
		this.rating = rating;
		this.review = review;
		this.doctorId = doctorId;
		this.patientId = patientId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	
	

}
