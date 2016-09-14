package com.contractfree.framework.service.rest;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;

import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.contractfree.framework.manager.UserManager;
import com.contractfree.framework.model.User;
import com.contractfree.framework.service.EmailService;
import com.contractfree.framework.template.EmailTemplate;



@Stateless
@Path("/signup")
public class SignUpRestService {
	
	private static final Logger LOGGER = Logger.getLogger( SignUpRestService.class.getName() );
	
	private static final String SUCCESS = "Registration successful";
	
	
	@Inject
	private UserManager userManager;
	
	/**
	 * 
	 * @param email
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("text/plain")
	public Response signUp(User emailParam){
		boolean dbAction = userManager.save(emailParam);
		if(dbAction){
			LOGGER.info("New registration successful : " + emailParam);
			EmailService.sendMail(new EmailTemplate("Congratulations",emailParam.getEmail(),emailParam.getId()));
			return Response.status(Response.Status.ACCEPTED).entity(SignUpRestService.SUCCESS).build();
		}else{
			LOGGER.severe("Fail registration : " + emailParam);
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}

}
