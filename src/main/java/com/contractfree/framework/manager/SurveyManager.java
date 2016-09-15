package com.contractfree.framework.manager;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.contractfree.framework.model.SurveyAnswer;
import com.contractfree.framework.model.SurveyQuestion;
import com.contractfree.framework.model.User;
import com.contractfree.framework.util.MailDigest;

@Stateless
public class SurveyManager {

	private static Logger LOGGER = Logger.getLogger(SurveyManager.class.getName());

	@Inject Resources resource;
	
	@Inject
	private UserManager userManager;
	
	public SurveyManager(){}
	
	/**
	 * 
	 * @param survey
	 * @return
	 */
	public boolean save(List<SurveyAnswer> answers){
		try {
			for (SurveyAnswer surveyAnswer : answers) {
				if(verifyEmailHash(surveyAnswer.getUserId(),surveyAnswer.getEmailHash())){
					resource.getEntityManager().persist(surveyAnswer);
					LOGGER.info("New answer persistence success : " + 
					surveyAnswer.getQuestionId() + " - " + surveyAnswer.getCreationDate());
				}else{
					LOGGER.severe("EMAIL HASH VERIFICATION FAILED : " + surveyAnswer.getEmailHash());
					return false;
				}
			}
			
		} catch (Exception e) {
			LOGGER.severe("PERSISTENCE ERROR - SURVEY SAVE " + e.getMessage());
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	/**
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<SurveyQuestion> findQuestions(){
		List<SurveyQuestion> questions = 
				resource.getEntityManager().createQuery("SELECT surveyQuestion FROM SurveyQuestion surveyQuestion").getResultList();
		return questions;
	}
	
	/**
	 * 
	 * @param userId
	 * @param emailHash
	 * @return
	 */
	public boolean verifyEmailHash(Long userId, String emailHash){
		User user = userManager.findById(userId);
		if(user!=null && user.getEmail()!=null){
			return emailHash.equals(MailDigest.digest(user.getEmail()));
		}else{
			return false;
		}
	}
}
