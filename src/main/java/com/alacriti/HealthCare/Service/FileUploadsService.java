package com.alacriti.HealthCare.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.alacriti.HealthCare.Entity.FileUploads;
import com.alacriti.HealthCare.Repository.FileUploadsRepository;
import com.alacriti.HealthCare.exception.CustomException;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Service
public class FileUploadsService {
	private static final Logger logger = LoggerFactory.getLogger(FileUploadsService.class);
	@Autowired
	private Cloudinary cloudinary;
	@Autowired
	public FileUploadsRepository repo;

	@SuppressWarnings("unchecked")
	public FileUploads uploadFile(MultipartFile file, String fileName, int id) throws Exception{
		logger.info("Saving patient reports into database");
		String publicId = UUID.randomUUID().toString();
		FileUploads saveFile = new FileUploads();
		

		Map<String, String> result = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.asMap("publicId", publicId));
		System.out.println(result.toString());
		String imageUrl = result.get("url");
		saveFile.setFile(imageUrl);
		saveFile.setPatientId(id);
		saveFile.setFileName(fileName);
		saveFile.setDate();
		saveFile.setImageId(publicId);
		logger.info("Patient reports saved successfully");
		return repo.save(saveFile);
	}
	
	public List<FileUploads> getReports(int id) {
		logger.info("Fetching reports of a patient");
		return repo.findByPatientId(id);
	}
	
	public void deleteFiles(String imageId) throws IOException {
		try {
			FileUploads file = repo.findByImageId(imageId);
			if(file == null) throw new CustomException("File Not found");
			cloudinary.uploader().destroy(imageId, ObjectUtils.emptyMap());
			repo.delete(file);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage());
		}
		
	}
}
