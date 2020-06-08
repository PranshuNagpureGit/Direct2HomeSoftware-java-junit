package com.techverito.sattv.menuoptioninput;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UpdateNotificationInputTest {

	@Test
	void testUpdateNotificationInput_constructor() {
		UpdateNotificationInput updateNotificationInput = new UpdateNotificationInput("pk@gmail.com","12345789");
		assertEquals("pk@gmail.com", updateNotificationInput.getEmailId());
		assertEquals("12345789", updateNotificationInput.getPhoneNumber());
	}

}
