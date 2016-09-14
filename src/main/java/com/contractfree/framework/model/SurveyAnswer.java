package com.contractfree.framework.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class SurveyAnswer implements Serializable{

	private static final long serialVersionUID = -2720319333402231147L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private Long questionId;
	
	private Long userId;
	
	private String content;
	
	private Date creationDate;
	
	@Transient
	private String emailHash;
	
	
	public SurveyAnswer(){
		this.creationDate = Calendar.getInstance().getTime();
	}

	public SurveyAnswer(String content, Long userId, Long questionId){
		this.content = content;
		this.userId = userId;
		this.questionId = questionId;
		this.creationDate = Calendar.getInstance().getTime();
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getQuestionId() {
		return questionId;
	}


	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}


	public Long getUserId() {
		return userId;
	}


	public void setUserId(Long userId) {
		this.userId = userId;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public Date getCreationDate() {
		return creationDate;
	}
	
	public String getEmailHash() {
		return emailHash;
	}

	public void setEmailHash(String emailHash) {
		this.emailHash = emailHash;
	}

	@Override
	public String toString(){
		return "{{"+this.id + "--" + this.content + " -- " + this.userId + " -- " + this.questionId+ " -- " + this.emailHash +"}}";
	}
	
	
}
