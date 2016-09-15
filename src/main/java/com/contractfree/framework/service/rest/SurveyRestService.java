package com.contractfree.framework.service.rest;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.contractfree.framework.manager.SurveyManager;
import com.contractfree.framework.model.SurveyAnswer;
import com.contractfree.framework.model.SurveyQuestion;

@Stateless
@Path("/survey")
public class SurveyRestService {

	private static final Logger LOGGER = Logger.getLogger( SurveyRestService.class.getName() );
	
	
	@Inject
	SurveyManager surveyManager;

	/**
	 * Submit answers of the survey to db
	 * @param surveyParam
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("text/plain")
	public Response save(List<SurveyAnswer> surveyParam){
		LOGGER.fine("Save survey calling "+ surveyParam);
		boolean dbAction = surveyManager.save(surveyParam);
		if(dbAction){
			LOGGER.info("Submit survey answers successful : " + surveyParam);
			return Response.status(Response.Status.ACCEPTED).build();
		}else{
			LOGGER.severe("Fail submit survey answers : " + surveyParam);
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}
	
	/**
	 * 
	 * @return List<SurveyQuestion> with all questions in db
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<SurveyQuestion> query(){
		LOGGER.fine("QUERY SURVEY QUESTIONS");
		return surveyManager.findQuestions();
	}

}