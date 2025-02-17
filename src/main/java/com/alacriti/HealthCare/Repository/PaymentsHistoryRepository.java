package com.alacriti.HealthCare.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alacriti.HealthCare.Entity.PaymentsHistory;

@Repository
public interface PaymentsHistoryRepository extends JpaRepository<PaymentsHistory, Integer> {
	public List<PaymentsHistory> findByDoctorId(int doctor_id);
	
	public List<PaymentsHistory> findByPatientId(int patient_id);
	
}
