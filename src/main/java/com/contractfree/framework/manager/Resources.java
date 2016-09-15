package com.contractfree.framework.manager;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Resources {

	@PersistenceContext(unitName = "userUnit")
	EntityManager entityManager;

	@Produces
	public EntityManager getEntityManager() {
		return entityManager;
	}
}
