package com.alacriti.HealthCare.Entity;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class PaymentsHistory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "card", referencedColumnName = "id")
	private Cards card;
	
	
	private int doctorId;
	private int patientId;
	private String date;
	private String timings;
	private int amount;
	private String type;
	private String paymentDate;
	private String transactionId;
	
	public PaymentsHistory() {}

	public PaymentsHistory(int id, Cards card, int doctorId, int patientId, String date, String timings, int amount,
			String type, String paymentDate, String transactionId) {
		super();
		this.id = id;
		this.card = card;
		this.doctorId = doctorId;
		this.patientId = patientId;
		this.date = date;
		this.timings = timings;
		this.amount = amount;
		this.type = type;
		this.paymentDate = paymentDate;
		this.transactionId = transactionId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cards getCard() {
		return card;
	}

	public void setCard(Cards card) {
		this.card = card;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate() {
		this.paymentDate = new Date().toString();
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId() {
		this.transactionId =  UUID.randomUUID().toString();;
	}

	
		
	
}
