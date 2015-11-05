package org.craftedsw.tripservicekata.trip;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.craftedsw.tripservicekata.user.User;

public class TripServiceTest {
	private TripService tripService;

	private User loggedUser;

	@Before
	public void setUp() {
		tripService = mock(TripService.class);
		loggedUser = new User();
	}

	@Test
	public void user_with_no_friends_has_no_trips() {
		when(tripService.getLoggedUser()).thenReturn(loggedUser);
		assertNotNull(tripService.getTripsByUser(new User()));
	}

}
