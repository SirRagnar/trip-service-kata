package org.craftedsw.tripservicekata.user;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UserSessionTest {

	@Before
	public void setUp() {

	}

	@Test
	public void static_get_instance_returns_not_null_instance() {
		assertNotNull(UserSession.getInstance());
	}

	@Test
	public void two_different_calls_to_getInstance_returns_the_same_instance() {
		UserSession userSessionA = UserSession.getInstance();
		UserSession userSessionB = UserSession.getInstance();

		assertEquals(userSessionA, userSessionB);
	}
}
