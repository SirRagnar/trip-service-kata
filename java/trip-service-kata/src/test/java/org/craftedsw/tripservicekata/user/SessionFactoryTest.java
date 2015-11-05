package org.craftedsw.tripservicekata.user;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SessionFactoryTest {

	@Before
	public void setUp() {

	}

	@Test
	public void getUserSession_returns_a_not_null_UserSession() {
		assertNotNull(SessionFactory.getUserSession());
	}

}
