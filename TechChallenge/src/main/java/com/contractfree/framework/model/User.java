package com.contractfree.framework.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User implements Serializable{


	private static final long serialVersionUID = -1335775590803998134L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String email;
	
	private Date creationDate;
	
	public User(){
		this.creationDate = Calendar.getInstance().getTime();
	}
	
	public User(String email){
		this.email = email;
		this.creationDate = Calendar.getInstance().getTime();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Date getCreationDate(){
		return creationDate;
	}
	
	@Override
	public String toString(){
		return this.getEmail() + " - " + this.getCreationDate();
	}
	
}
