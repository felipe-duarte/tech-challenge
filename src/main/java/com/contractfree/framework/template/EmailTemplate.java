package com.contractfree.framework.template;

import com.contractfree.framework.util.MailDigest;

public class EmailTemplate {
	
	private String message;

	private String sender;

	private String subject;

	private String recipient;
	
	private String baseUrl;

	
	public EmailTemplate(String subject, String recipient, Long userId){
		this.subject = subject;
		this.recipient = recipient;
		this.sender = "contacts@contractfree.com";
		this.baseUrl = System.getProperty("surveyApp.baseURL");
		this.message = " <h1>Congratulations</h1>"
				+ "<p>You are already registered into our ContractFree services, and we are very glad of it.</p> "
				+ "<p>In order to know better what you think about our offer, follow below a "
				+ "link to a very quick survey, that should improve our services before we launch our new WebApp next month!</p>"
				+ "<p>All our efforts are directed to give what you really wan't and need! ;)</p>"
				+ "<br>"
				+ "<p><a href=\""+ this.baseUrl+"/TechChallenge/index.html#!/survey/"+
				userId + "/" + MailDigest.digest(recipient) +"\"> Click Here to Survey Link </p>";
		
		System.out.println("Message: " + message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	
}
