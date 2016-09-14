package com.contractfree.framework.manager;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.contractfree.framework.model.SurveyAnswer;
import com.contractfree.framework.model.SurveyQuestion;

@Stateless
public class SurveyManager {

	private static Logger LOGGER = Logger.getLogger(SurveyManager.class.getName());

	@Inject
	private Resources em;
	
	public SurveyManager(){}
	
	/**
	 * 
	 * @param survey
	 * @return
	 */
	public boolean save(List<SurveyAnswer> answers){
		try {
			for (SurveyAnswer surveyAnswer : answers) {
				em.getEntityManager().persist(surveyAnswer);
				LOGGER.info("New answer persistence success : " + surveyAnswer.getQuestionId() + " - " + surveyAnswer.getCreationDate());
			}
			
		} catch (Exception e) {
			LOGGER.severe("PERSISTENCE ERROR - SURVEY SAVE " + e.getMessage());
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
		CriteriaBuilder cb = em.getEntityManager().getCriteriaBuilder();
		CriteriaQuery<SurveyQuestion> criteria = cb.createQuery(SurveyQuestion.class);
		Root<SurveyQuestion> rootEntry = criteria.from(SurveyQuestion.class);
		CriteriaQuery<SurveyQuestion> all = criteria.select(rootEntry);
        TypedQuery<SurveyQuestion> allQuery = em.getEntityManager().createQuery(all);
		
		List<SurveyQuestion> questions = allQuery.getResultList();
		return questions;
	}
}
