package org.craftedsw.tripservicekata.trip;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.craftedsw.tripservicekata.user.User;

public class TripServiceTest {
	private TripService tripService;

	private User loggedUser;

	@Before
	public void setUp() {
		tripService = mock(TripService.class);
		when(tripService.getLoggedUser()).thenReturn(loggedUser);
		loggedUser = new User();
	}

	@Test
	public void user_with_no_friends_has_no_trips() {
		User otherUser = new User();
		List<Trip> trips = tripService.getTripsByUser(otherUser);
		assertNotNull(trips);
		assertEquals(0,trips.size());
	}
	
	@Test
	public void if_user_has_no_friends_findTripsByUser_is_not_called(){
		User otherUser = new User();
		tripService.getTripsByUser(otherUser);
		verify(tripService, Mockito.times(0)).tripDAOWrapper.findTripsByUser(otherUser);
	}
	
	@Test
	public void user_with_logged_user_in_her_friend_has_trips(){
		User coolKid = new User();
		coolKid.addFriend(new User());
		coolKid.addFriend(new User());
		coolKid.addFriend(loggedUser);
		
		List<Trip> tripsToFound = new ArrayList<Trip>();	
		tripsToFound.add(new Trip());
		tripsToFound.add(new Trip());
		tripsToFound.add(new Trip());
		
		when(tripService.tripDAOWrapper.findTripsByUser(coolKid)).thenReturn(tripsToFound);
		
		List<Trip> tripsFound = tripService.tripDAOWrapper.findTripsByUser(coolKid);
		assertEquals(tripsToFound,tripsFound);		
	}

}
