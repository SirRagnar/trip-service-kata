package org.craftedsw.tripservicekata.user;

public class SessionFactory {
	private static final UserSession userSession = new UserSession();
	
	public static UserSession getUserSession() {
		return userSession;
	}

}
