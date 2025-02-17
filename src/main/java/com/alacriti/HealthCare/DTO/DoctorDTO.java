package com.alacriti.HealthCare.DTO;

import java.util.List;

public class DoctorDTO {
	private int age;
	private String gender;
	private List<String> availableDays;
	private String specialitiy;
	private int experience;
	
	private int consultationFees;
	private String address;
	private String city;
	private String state;
	
	private boolean online;
	private String clinic_name;
	private String start_time;
	private String end_time;
	
	public DoctorDTO() {}

	public DoctorDTO(int age, String gender, List<String> availableDays, String specialitiy, int experience,
			int consultationFees, String address, String city, String state, boolean online, String clinic_name,
			String start_time, String end_time) {
		super();
		this.age = age;
		this.gender = gender;
		this.availableDays = availableDays;
		this.specialitiy = specialitiy;
		this.experience = experience;
		this.consultationFees = consultationFees;
		this.address = address;
		this.city = city;
		this.state = state;
		this.online = online;
		this.clinic_name = clinic_name;
		this.start_time = start_time;
		this.end_time = end_time;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<String> getAvailableDays() {
		return availableDays;
	}

	public void setAvailableDays(List<String> availableDays) {
		this.availableDays = availableDays;
	}


	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public int getConsultationFees() {
		return consultationFees;
	}

	public void setConsultationFees(int consultationFees) {
		this.consultationFees = consultationFees;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public boolean isOnline() {
		return online;
	}

	public void setOnline(boolean online) {
		this.online = online;
	}

	public String getClinic_name() {
		return clinic_name;
	}

	public void setClinic_name(String clinic_name) {
		this.clinic_name = clinic_name;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public String getSpecialitiy() {
		return specialitiy;
	}

	public void setSpecialitiy(String specialitiy) {
		this.specialitiy = specialitiy;
	}
	
	
	


	
	
	
}
