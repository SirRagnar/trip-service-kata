package org.craftedsw.tripservicekata.user;

public class SessionFactory {

	public UserSession getUserSession() {
		return UserSession.getInstance();
	}

}
