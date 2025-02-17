package com.alacriti.HealthCare.DTO;

public class PaymentsHistoryDTO {

	private int doctorId;
	private int patientId;
	private String date;
	private String timings;
	private int amount;
	private CardsDTO card;
	private String type;
	
	public PaymentsHistoryDTO() {}

	public PaymentsHistoryDTO(int doctorId, int patientId, String date, String timings, int amount, CardsDTO card,
			String type) {
		super();
		this.doctorId = doctorId;
		this.patientId = patientId;
		this.date = date;
		this.timings = timings;
		this.amount = amount;
		this.card = card;
		this.type = type;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTimings() {
		return timings;
	}

	public void setTimings(String timings) {
		this.timings = timings;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public CardsDTO getCard() {
		return card;
	}

	public void setCard(CardsDTO card) {
		this.card = card;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

		
	
}
