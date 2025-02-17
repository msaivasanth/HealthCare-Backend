package com.alacriti.HealthCare.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Doctors {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "docter_id", referencedColumnName = "id")
	private Users user;

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

	public Doctors() {
	}

	public Doctors(int id, Users user, int age, String gender, List<String> availableDays, String specialitiy,
			int experience, int consultationFees, String address, String city, String state, boolean online,
			String clinic_name, String start_time, String end_time) {
		super();
		this.id = id;
		this.user = user;
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

	public int getId() {
		return id;
	}

	public Users getUser() {
		return user;
	}

	public int getAge() {
		return age;
	}

	public String getGender() {
		return gender;
	}

	public List<String> getAvailableDays() {
		return availableDays;
	}

	public int getExperience() {
		return experience;
	}

	public int getConsultationFees() {
		return consultationFees;
	}

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setAvailableDays(List<String> availableDays) {
		this.availableDays = availableDays;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public void setConsultationFees(int consultationFees) {
		this.consultationFees = consultationFees;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCity(String city) {
		this.city = city;
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

	@Override
	public String toString() {
		return "Doctors [id=" + id + ", user=" + user + ", age=" + age + ", gender=" + gender + ", availableDays="
				+ availableDays + ", specialitiy=" + specialitiy + ", experience=" + experience + ", consultationFees="
				+ consultationFees + ", address=" + address + ", city=" + city + ", state=" + state + ", online="
				+ online + ", clinic_name=" + clinic_name + ", start_time=" + start_time + ", end_time=" + end_time
				+ "]";
	}

}
