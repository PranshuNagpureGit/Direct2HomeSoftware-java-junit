package com.techverito.sattv.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class SessionTest {

	@Test
	public void testGetInstance_checkIfSingleton() {
		assertEquals(Session.getInstance(), Session.getInstance());
	}
	
	@Test
	public void testSetterGetter() {
		Session session = Session.getInstance();
		session.setCustomerId(100L);
		assertEquals(100L, session.getCustomerId());
	}

}
