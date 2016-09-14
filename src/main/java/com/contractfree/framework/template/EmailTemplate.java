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
		this.sender = "contacts@freecontract.com";
		this.baseUrl = System.getProperty("surveyApp.baseURL");
		this.message = "<h1>Congratulations</h1> "
				+ "<span>Survey Link :"+this.baseUrl+"/TechChallenge/survey.html#/"+
				userId + "/" + MailDigest.digest(recipient) + "</span>";
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
