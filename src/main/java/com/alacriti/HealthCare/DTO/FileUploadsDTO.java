package com.alacriti.HealthCare.DTO;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadsDTO {

	private int patientId;
	private MultipartFile file;
	private String fileName;
	
	public FileUploadsDTO() {}

	public FileUploadsDTO(int patientId, MultipartFile file, String fileName) {
		super();
		this.patientId = patientId;
		this.file = file;
		this.fileName = fileName;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	
	
}
