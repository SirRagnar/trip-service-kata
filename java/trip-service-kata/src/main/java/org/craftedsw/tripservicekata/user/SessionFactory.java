package org.craftedsw.tripservicekata.user;

public class SessionFactory {
	private static final UserSession userSession = new UserSession();

	public UserSession getUserSession() {
		return userSession;
	}

}
