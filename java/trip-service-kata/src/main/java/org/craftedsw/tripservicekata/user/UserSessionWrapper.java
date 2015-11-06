package org.craftedsw.tripservicekata.user;

public class UserSessionWrapper {

	public User getLoggedUser() {
		return UserSession.getInstance().getLoggedUser();
	}

}
