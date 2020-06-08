package com.techverito.sattv.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AdditionalServiceTest {
		
	@Test
	public void testAdditionalService_constructor() {
		AdditionalService subscription = new AdditionalService("abc", 12);
		assertEquals("abc",subscription.getName());
		assertEquals(12,subscription.getAmount());
	}
	

}
