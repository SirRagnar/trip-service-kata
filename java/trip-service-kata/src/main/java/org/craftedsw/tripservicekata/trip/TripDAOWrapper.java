package org.craftedsw.tripservicekata.trip;

import java.util.List;

import org.craftedsw.tripservicekata.user.User;

public class TripDAOWrapper {

	public List<Trip> findTripsByUser(User user) {
		return TripDAO.findTripsByUser(user);
	}

}
