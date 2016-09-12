package com.contractfree.framework.template;

import java.util.ArrayList;
import java.util.List;

public class SurveyTemplate {

	private List<String> questionList;
	
	private List<String> answerList;
	
	public SurveyTemplate(){
		questionList = new ArrayList<String>();
		answerList = new ArrayList<String>();
	}

	public boolean addQuestion(String question){
		return questionList.add(question);
	}
	
	public boolean addAnswer(String answer){
		return answerList.add(answer);
	}
	
	public List<String> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(List<String> questionList) {
		this.questionList = questionList;
	}

	public List<String> getAnswerList() {
		return answerList;
	}

	public void setAnswerList(List<String> answerList) {
		this.answerList = answerList;
	}
	
}
