package com.techverito.sattv.menuoptionoutput;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.techverito.sattv.domain.Subscription;

class ViewSubscriptionOutputTest {

	@Test
	void testViewSubscriptionOutput_constructor() {
		ViewSubscriptionOutput viewSubscriptionOutput = new ViewSubscriptionOutput(new Subscription());
		Assertions.assertNotNull(viewSubscriptionOutput.getSubscription());
	}

}
