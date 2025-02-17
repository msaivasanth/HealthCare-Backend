package com.alacriti.HealthCare.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alacriti.HealthCare.Entity.Patients;
import com.alacriti.HealthCare.Entity.Users;

public interface PatientRepository extends JpaRepository<Patients, Integer>  {
	public Patients findByUser(Users user);
	public Patients findById(int id);
}
