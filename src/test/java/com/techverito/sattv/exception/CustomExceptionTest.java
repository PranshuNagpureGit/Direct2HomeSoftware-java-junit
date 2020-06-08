package com.techverito.sattv.exception;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CustomExceptionTest {

	@Test
	public void testCustomException_creation() {
		CustomException customException = new CustomException("This is test exception");
		assertEquals("This is test exception", customException.getMessage());
	}

}
