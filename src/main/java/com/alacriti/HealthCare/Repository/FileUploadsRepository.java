package com.alacriti.HealthCare.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.alacriti.HealthCare.Entity.FileUploads;

public interface FileUploadsRepository extends JpaRepository<FileUploads, Integer> {
	public List<FileUploads> findByPatientId(int id);
	public FileUploads findByImageId(String id);
}
