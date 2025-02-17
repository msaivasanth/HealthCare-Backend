package com.alacriti.HealthCare.DTO;

public class AppointmentDTO {

	private int doctorId;
	
	private int patientId;
	
	private String time;
	private String date;
	private String type;
	private String toEmail;
	private String status;
	private String roomId;
	
	public AppointmentDTO() {}

	public AppointmentDTO(int doctorId, int patientId, String time, String date, String type, String toEmail,
			String status, String roomId) {
		super();
		this.doctorId = doctorId;
		this.patientId = patientId;
		this.time = time;
		this.date = date;
		this.type = type;
		this.toEmail = toEmail;
		this.status = status;
		this.roomId = roomId;
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

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getToEmail() {
		return toEmail;
	}

	public void setToEmail(String toEmail) {
		this.toEmail = toEmail;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	
		
		
}

