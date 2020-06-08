package com.techverito.sattv.menuoptionoutput;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UpdateNotificationOutputTest {

	@Test
	void testUpdateNotificationOutput_constructor() {
		UpdateNotificationOutput updateNotification = new UpdateNotificationOutput("kp@gmail.com","987654321");
		assertEquals("kp@gmail.com", updateNotification.getEmailId());
		assertEquals("987654321", updateNotification.getPhoneNumber());
	}

}
