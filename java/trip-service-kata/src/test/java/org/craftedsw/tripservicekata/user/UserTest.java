package org.craftedsw.tripservicekata.user;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.craftedsw.tripservicekata.trip.Trip;
import org.junit.Before;
import org.junit.Test;

public class UserTest {
	
	private User user;
	
	@Before
	public void setUp(){
		user = new User();
	}
	
	@Test
	public void new_user_has_not_null_friend_list(){
		assertNotNull(user.getFriends());
	}
	
	@Test
	public void new_user_has_not_null_trips(){
		assertNotNull(user.trips());
	}
	
	@Test
	public void addFriend_adds_one_friend_to_friend_list(){
		user.addFriend(new User());
		assertEquals(1,user.getFriends().size());
	}
	
	@Test
	public void addTrip_adds_one_trip_to_trip_list(){
		user.addTrip(new Trip());
		assertEquals(1,user.trips().size());
	}
}
