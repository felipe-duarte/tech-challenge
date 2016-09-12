	package com.contractfree.framework.manager;


import java.util.logging.Logger;

import javax.inject.Inject;

import javax.ejb.Stateless;

import com.contractfree.framework.model.User;


@Stateless
public class UserManager{

	private static Logger LOGGER = Logger.getLogger(UserManager.class.getName());

	@Inject
	private Resources em;

	/**
	 * 
	 */
	public UserManager() {
	}

	/**
	 * 
	 * @param user
	 * @return true if success to store data and false otherwise
	 */
	public boolean save(User user) {
		try {
			em.getEntityManager().persist(user);
			LOGGER.info("New user registration persistence success : " + user.getEmail() + " - " + user.getCreationDate());
		} catch (Exception e) {
			LOGGER.severe("PERSISTENCE ERROR - USER SAVE : " + e.getMessage());
			return false;
		}
		return true;
	}

}