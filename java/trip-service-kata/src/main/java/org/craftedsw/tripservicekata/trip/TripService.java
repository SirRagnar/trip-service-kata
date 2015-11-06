package org.craftedsw.tripservicekata.trip;

import java.util.ArrayList;
import java.util.List;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.craftedsw.tripservicekata.user.UserSession;
import org.craftedsw.tripservicekata.user.UserSessionWrapper;

public class TripService {
	
	private TripDAOWrapper tripDaoWrapper;
	
	private UserSessionWrapper userSessionWrapper;

	public TripService(TripDAOWrapper tripDaoWrapper, UserSessionWrapper userSessionWrapper) {
		this.tripDaoWrapper = tripDaoWrapper;
		this.userSessionWrapper = userSessionWrapper;
	}

	public List<Trip> getTripsByUser(User user) throws UserNotLoggedInException {
		List<Trip> tripList = new ArrayList<Trip>();
		User loggedUser = getLoggedUser();
		boolean isFriend = false;
		if (loggedUser != null) {
			for (User friend : user.getFriends()) {
				if (friend.equals(loggedUser)) {
					isFriend = true;
					break;
				}
			}
			if (isFriend) {
				tripList = findTripsByUser(user);
			}
			return tripList;
		} else {
			throw new UserNotLoggedInException();
		}
	}

	public List<Trip> findTripsByUser(User user) {
		return TripDAO.findTripsByUser(user);
	}

	public User getLoggedUser() {
		return UserSession.getInstance().getLoggedUser();
	}

}
