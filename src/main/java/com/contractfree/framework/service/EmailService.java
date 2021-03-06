package com.contractfree.framework.service;

import java.util.Properties;
import java.util.logging.Logger;

import javax.mail.*;
import javax.mail.internet.*;

import com.contractfree.framework.template.EmailTemplate;



public class EmailService {

	private static final Logger LOGGER = Logger.getLogger( EmailService.class.getName() );
	
	public static void sendMail(EmailTemplate template){
		  String to = template.getRecipient();
	      String from = template.getSender();
	      String host = "";

	      Properties properties = System.getProperties();
	      properties.setProperty("mail.smtp.host", host);
	      Session session = Session.getDefaultInstance(properties);

	      try{
	    	 
	    	 MimeMessage message = new MimeMessage(session);
	    	 Multipart multiPartMessage = new MimeMultipart();
	    	 MimeBodyPart htmlMessage = new MimeBodyPart();
	 
	    	 message.setFrom(new InternetAddress(from));
	         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
	         message.setSubject(template.getSubject());

	         htmlMessage.setContent(template.getMessage(), "text/html; charset=utf-8");
	         
	         multiPartMessage.addBodyPart(htmlMessage);
	         
	         message.setContent(multiPartMessage);
	         
	         message.saveChanges();
	         
	         Transport.send(message);
	         
	         LOGGER.info("EMAIL SENT TO : " + to);

	      }catch (MessagingException ex) {
	        LOGGER.severe("ERROR SENDING MAIL - " + ex.getMessage());
	      }
	   }
	
}
	
