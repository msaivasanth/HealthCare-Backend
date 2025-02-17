package com.alacriti.HealthCare.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Users {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
	private int id;
	@Column(unique=true)
	private String email;
	private String name;
	private String role;
	
	

	public Users(int id, String email, String name, String dob, String role, String state, String city) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.role = role;
	}
	
	public Users() {}

	public int getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}

	public String getRole() {
		return role;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", email=" + email + ", name=" + name + ", role=" + role + "]";
	}

	
	
}
