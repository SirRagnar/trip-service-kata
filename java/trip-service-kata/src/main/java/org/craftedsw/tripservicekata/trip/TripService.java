package org.craftedsw.tripservicekata.trip;

import java.util.ArrayList;
import java.util.List;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.craftedsw.tripservicekata.user.UserSessionWrapper;

public class TripService {
	
	private TripDAOWrapper tripDAOWrapper;
	
	private UserSessionWrapper userSessionWrapper;

	public TripService(TripDAOWrapper tripDaoWrapper, UserSessionWrapper userSessionWrapper) {
		this.tripDAOWrapper = tripDaoWrapper;
		this.userSessionWrapper = userSessionWrapper;
	}

	public List<Trip> getTripsByUser(User user) throws UserNotLoggedInException {
		List<Trip> tripList = new ArrayList<Trip>();
		User loggedUser = userSessionWrapper.getLoggedUser();
		boolean isFriend = false;
		if (loggedUser != null) {
			for (User friend : user.getFriends()) {
				if (friend.equals(loggedUser)) {
					isFriend = true;
					break;
				}
			}
			if (isFriend) {
				tripList = tripDAOWrapper.findTripsByUser(user);
			}
			return tripList;
		} else {
			throw new UserNotLoggedInException();
		}
	}

	/**
	 * @deprecated Use {@link org.craftedsw.tripservicekata.trip.TripDAOWrapper#findTripsByUser(User)} instead
	 */
	public List<Trip> findTripsByUser(User user) {
		return tripDAOWrapper.findTripsByUser(user);
	}

	/**
	 * @deprecated Use {@link org.craftedsw.tripservicekata.user.UserSessionWrapper#getLoggedUser()} instead
	 */
	public User getLoggedUser() {
		return userSessionWrapper.getLoggedUser();
	}

}
