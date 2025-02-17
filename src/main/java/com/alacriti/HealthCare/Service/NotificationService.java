package com.alacriti.HealthCare.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.alacriti.HealthCare.Entity.Appointments;
import com.alacriti.HealthCare.Entity.Users;

@Service
public class NotificationService {
	
	@Autowired
	private AppointmentsService appoService;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private UserService userService;
	
	@Scheduled(fixedRate = 60000)
	public void sendNotification()  {
		List<Appointments> lis = appoService.getAllAppointments();
		
		for(Appointments appointment:lis) {
			
			 String time = appointment.getTime();
			 String date1 = appointment.getDate();
			 
			 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
			 DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM.dd.yyyy");
			 
			 LocalDate date = LocalDate.parse(date1, dateFormatter);
			 LocalTime localTime = LocalTime.parse(time, formatter);
			 
			 LocalDate currentDate = LocalDate.now();
			 
			 LocalDateTime localDateTime = LocalDateTime.of(date, localTime).withSecond(0).withNano(0);
			 
			 LocalDateTime today = LocalDateTime.now().withSecond(0).withNano(0);
//			 System.out.println("DateTime: " + localDateTime.minusMinutes(15).toString() + " " + today.toString() );
			 
			 if(date.toString().equals(currentDate.toString())) {
				 if(localDateTime.minusMinutes(15).equals(today)) {
					 System.out.println("Inside mail notification");
					 Users user = userService.findUserById(appointment.getPatientId());
					 emailService.sendEmail(user.getEmail(), "Health Care", String.format("You have appointment on %s at %s", appointment.getDate(), appointment.getTime()));
				 }
			 }
			 
			 
			 
			 
		}
	}
}
