package com.techverito.sattv.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class AuthenticationInputTest {

	@Test
	public void testAuthenticationInput_construction() {
		AuthenticationInput authInput = new AuthenticationInput(100L, "abc");
		assertEquals(100L, authInput.getCustomerId());
		assertEquals("abc", authInput.getPassword());
	}

}
