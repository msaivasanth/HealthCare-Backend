package com.alacriti.HealthCare.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alacriti.HealthCare.Entity.FileUploads;
import com.alacriti.HealthCare.Service.FileUploadsService;

@RestController
@RequestMapping("/api/files")
public class FileUploadsController {
	
	@Autowired
	public FileUploadsService service;
	@PostMapping("upload")
	public ResponseEntity<?> uploadFile(
			@RequestParam MultipartFile file,
			@RequestParam String fileName,
			@RequestParam String  patientId
			) {
		try {
			FileUploads result = service.uploadFile(file, fileName, Integer.parseInt(patientId));
			return ResponseEntity.ok(result);
			
		} catch (Exception e) {
			return new  ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping("get-reports/{id}")
	public ResponseEntity<List<FileUploads>> getReportsById(@PathVariable("id") int id) {
		List<FileUploads> result = service.getReports(id);
		return ResponseEntity.ok(result);
	}
	
	@DeleteMapping("delete-file/{id}")
	public ResponseEntity<?> deleteFile(@PathVariable("id") String id) {
		try {
			service.deleteFiles(id);
			return new ResponseEntity<>("File Deleted successfully", HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
	}
}
