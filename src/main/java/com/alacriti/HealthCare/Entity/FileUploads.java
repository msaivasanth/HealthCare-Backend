package com.alacriti.HealthCare.Entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class FileUploads {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int patientId;
	private String file;
	private String fileName;
	private String date;
	private String imageId;
	
	public FileUploads() {}

	public FileUploads(int id, int patientId, String file, String fileName, String date, String imageId) {
		super();
		this.id = id;
		this.patientId = patientId;
		this.file = file;
		this.fileName = fileName;
		this.date = date;
		this.imageId = imageId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getDate() {
		return date;
	}

	public void setDate() {
		this.date = new Date().toString();
	}

	public String getImageId() {
		return imageId;
	}

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}

		
		
}
