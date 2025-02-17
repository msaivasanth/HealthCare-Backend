package com.alacriti.HealthCare.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.alacriti.HealthCare.Entity.Appointments;

public interface AppointmentsRepository extends JpaRepository<Appointments, Integer> {
	public List<Appointments> findByDoctorId(int doctor_id);
	public List<Appointments> findByPatientId(int patinet_id);
	public List<Appointments> findByDateAndDoctorId(String date, int id);
	
	
	
	public Appointments findById(int id);
	
	@Query("SELECT app "+"From Appointments app "+ "wHERE app.date = :givenDate and app.doctorId = :id")
	List<Appointments> findByDate(@Param("givenDate") String date, @Param("id") int id) ; 
	
	@Query("SELECT app "+"From Appointments app "+ "wHERE app.date = :givenDate")
	List<Appointments> findByDate1(@Param("givenDate") String date) ; 
	
	@Query("SELECT app "+"From Appointments app "+ "wHERE app.date = :givenDate and app.patientId = :id")
	List<Appointments> findByDateForPatient(@Param("givenDate") String date, @Param("id") int id) ; 
}
 