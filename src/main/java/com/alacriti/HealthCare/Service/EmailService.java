package com.alacriti.HealthCare.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {
	@Autowired
	private JavaMailSender mail;
	
	public void sendEmail(String toEmail, String subject, String body) {
		try {
			MimeMessage mailService = mail.createMimeMessage();
			MimeMessageHelper mailHelper = new MimeMessageHelper(mailService, true);
			mailHelper.setTo(toEmail);
			mailHelper.setSubject(subject);
			mailHelper.setText(body, true);
			mail.send(mailService);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
}
