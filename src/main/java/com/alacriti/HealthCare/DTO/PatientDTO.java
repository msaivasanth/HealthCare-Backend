package com.alacriti.HealthCare.DTO;

public class PatientDTO {

	private String mobile;
	private int age;
	private String medicalHistory;
	private String healthConditions;
	private String gender;
	private String bloodGroup;
	
	public PatientDTO() {}

	public PatientDTO(String mobile, int age, String medicalHistory, String healthConditions, String gender,
			String bloodGroup) {
		super();
		this.mobile = mobile;
		this.age = age;
		this.medicalHistory = medicalHistory;
		this.healthConditions = healthConditions;
		this.gender = gender;
		this.bloodGroup = bloodGroup;
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
