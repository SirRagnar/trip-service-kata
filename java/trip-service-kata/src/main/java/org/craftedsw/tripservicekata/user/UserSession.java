package org.craftedsw.tripservicekata.user;

import org.craftedsw.tripservicekata.exception.CollaboratorCallException;

public class UserSession {
	
	private static final SessionFactory sessionFactory = new SessionFactory();
	
	protected UserSession() {
		
	}
	
	public static UserSession getInstance() {
		return sessionFactory.getUserSession();
	}

	public User getLoggedUser() {
		throw new CollaboratorCallException(
				"UserSession.getLoggedUser() should not be called in an unit test");
	}

}
