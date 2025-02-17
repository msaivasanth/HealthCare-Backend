package com.alacriti.HealthCare.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alacriti.HealthCare.Entity.Doctors;
import com.alacriti.HealthCare.Entity.Users;


@Repository
public interface DoctorRepository extends JpaRepository<Doctors, Integer> {
	public Doctors findByUser(Users user);
    List<Doctors> findByCityOrStateOrSpecialitiy(String city, String state, String specialitiy);
    List<Doctors> findByCityAndStateAndSpecialitiy(String city, String state, String specialitiy);
    public Doctors findById(int id);
}
