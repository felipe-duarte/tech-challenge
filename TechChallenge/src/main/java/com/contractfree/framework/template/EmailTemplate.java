package com.contractfree.framework.template;

public class EmailTemplate {
	
	private String message;
	
	private String sender;
	
	private String subject;
	
	private String recipient;
	
	public EmailTemplate(String message, String recipient){
		
	}
	
	public EmailTemplate(String message, String subject, String recipient){
		
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
