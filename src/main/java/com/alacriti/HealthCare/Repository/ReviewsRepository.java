package com.alacriti.HealthCare.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.alacriti.HealthCare.Entity.Reviews;

public interface ReviewsRepository extends JpaRepository<Reviews, Integer>{
	public List<Reviews> findByDoctorId(int id);
	public List<Reviews> findByPatientId(int id);
	public Reviews findByDoctorIdAndPatientId(int doctor, int patient);
	public Reviews findById(int id);
}
