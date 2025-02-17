package com.alacriti.HealthCare.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Patients {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
	private int id;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
	private Users user;
	
	private String mobile;
	private int age;
	private String medicalHistory;
	private String healthConditions;
	private String gender;
	private String bloodGroup;
	
	
	public Patients() {}


	public Patients(int id, Users user, String mobile, int age, String medicalHistory, String healthConditions,
			String gender, String bloodGroup) {
		super();
		this.id = id;
		this.user = user;
		this.mobile = mobile;
		this.age = age;
		this.medicalHistory = medicalHistory;
		this.healthConditions = healthConditions;
		this.gender = gender;
		this.bloodGroup = bloodGroup;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Users getUser() {
		return user;
	}


	public void setUser(Users user) {
		this.user = user;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getMedicalHistory() {
		return medicalHistory;
	}


	public void setMedicalHistory(String medicalHistory) {
		this.medicalHistory = medicalHistory;
	}


	public String getHealthConditions() {
		return healthConditions;
	}


	public void setHealthConditions(String healthConditions) {
		this.healthConditions = healthConditions;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getBloodGroup() {
		return bloodGroup;
	}


	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}


		
	
}
