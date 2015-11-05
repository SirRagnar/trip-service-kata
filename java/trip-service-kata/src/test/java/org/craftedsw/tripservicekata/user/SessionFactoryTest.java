package org.craftedsw.tripservicekata.user;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SessionFactoryTest {

	private SessionFactory sessionFactory;

	@Before
	public void setUp() {
		sessionFactory = new SessionFactory();
	}

	@Test
	public void getUserSession_returns_a_not_null_UserSession() {
		assertNotNull(sessionFactory.getUserSession());
	}

}
