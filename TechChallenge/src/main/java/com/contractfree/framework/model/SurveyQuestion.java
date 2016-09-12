package com.contractfree.framework.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SurveyQuestion implements Serializable{

	private static final long serialVersionUID = -2434155432833838082L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String content;
	
	public SurveyQuestion(){
	}
	
	public Long getId() {
		return id;
	}


	public String getContent() {
		return content;
	}

	public void setContent(String question) {
		this.content = question;
	}

}
