package com.alacriti.HealthCare.Service;

import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.alacriti.HealthCare.DTO.CardsDTO;
import com.alacriti.HealthCare.DTO.PaymentsHistoryDTO;
import com.alacriti.HealthCare.Entity.Cards;
import com.alacriti.HealthCare.Entity.Patients;
import com.alacriti.HealthCare.Entity.PaymentsHistory;
import com.alacriti.HealthCare.Entity.Users;
import com.alacriti.HealthCare.Repository.PaymentsHistoryRepository;
import com.alacriti.HealthCare.exception.CustomException;

import net.minidev.json.JSONObject;

@Service
public class PaymentsHistoryService {
	private static final Logger logger = LoggerFactory.getLogger(PaymentsHistoryService.class);
	
	@Autowired
	public CardService cardService;
	@Autowired
	public PaymentsHistoryRepository repo;
	
	@Autowired
	private EmailService emailService;
	@Autowired
	private PatientService patService;
	
	@Autowired
	private UserService userService;
	
	@SuppressWarnings("unused")
	public Object makePayment(PaymentsHistoryDTO details) {
		JSONObject res = new JSONObject();
		try {
			logger.info("Payment for appointment is processing");
			CardsDTO card = details.getCard();
			Cards paymentCard = cardService.checkCardDetails(card);
			if(paymentCard != null) {
				System.out.println("Payment CArd: " + paymentCard.getBalance());
				PaymentsHistory payment = new PaymentsHistory();
				
				BeanUtils.copyProperties(details, payment);
				payment.setCard(paymentCard);
				Cards card1 = cardService.deductMoney(details.getAmount(), card);
				System.out.println(card1.toString());
				payment.setPaymentDate();
				payment.setTransactionId();
				Users user = userService.findUserById(payment.getPatientId()); 
				Patients patient = patService.getPatientDetails1(user);
				String html = loadTemplate("static/invoice.html");
				emailService.sendEmail(patient.getUser().getEmail(), "Health Care Payments", String.format(html, patient.getUser().getName(), payment.getDate(), payment.getAmount(), payment.getTransactionId()));
				logger.info("Payment for appointment is completed");
				res.appendField("msg", "Payment for appointment is completed");
				return res;
			}
			else {
				throw new CustomException("Card not found");
				
			}
			
		} catch (CustomException e) {
			// TODO: handle exception
			logger.error(e.getMessage());
			res.appendField("erro", e.getMessage());
			return res;
		}
	}
	
	private String loadTemplate(String templatePath) {
		try {
			ClassPathResource resource = new ClassPathResource(templatePath);
			InputStream inputStream= resource.getInputStream();
			
			return new String(inputStream.readAllBytes());
		} catch (Exception e) {
			throw new RuntimeException("Error loading template" + e);
		}
		
	}
	
}
