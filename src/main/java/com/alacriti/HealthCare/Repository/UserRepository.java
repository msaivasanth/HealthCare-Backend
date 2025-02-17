package com.alacriti.HealthCare.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.alacriti.HealthCare.Entity.Users;
@Repository
public interface UserRepository  extends JpaRepository<Users, Integer>{
	public Users findByEmail(String email);
	public Users findById(int id);
	
	@Query("SELECT app From Users app WHERE app.name LIKE %:name% and app.role = 'doctor'")
	public List<Users> findByName(String name);
}
