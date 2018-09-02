package com.avinash.flightreservation.util;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtil {
	
	@Autowired
	private JavaMailSender sender;

	public void sendItinerary(String toAddress, String filePath){
		
		MimeMessage message = sender.createMimeMessage();
	
		try {
			
			//Mime helper has been used to create different message parts 
			//true - means mesage will have the different parts
			
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
			messageHelper.setTo(toAddress);										//add the address to send the mail message
			messageHelper.setSubject("Itinerary for  your Flight ");			//add the subject line to mail message
			messageHelper.setText("Please find your Itinerary Attached.");		//add the body to mail message
			messageHelper.addAttachment("Itinerary", new File(filePath));		//add the attachment to mail message
			sender.send(message);												//send the email
			
			
			
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	
	
	}
}
