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


@Stateless
@Path("/signup")
public class SignUpRestService {
	
	private static final Logger LOGGER = Logger.getLogger( SignUpRestService.class.getName() );
	
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
			String result = "Registration successful : " + emailParam;
			LOGGER.info("New registration successful : " + emailParam);
			return Response.status(Response.Status.ACCEPTED).entity(result).build();
		}else{
			LOGGER.severe("Fail registration : " + emailParam);
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}

}
