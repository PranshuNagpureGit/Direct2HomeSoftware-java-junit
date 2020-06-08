package com.techverito.sattv.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class SubscriptionTest {
		
	@Test
	public void testSubscription_constructor() {
		Subscription subscription = new Subscription();
		assertNotNull(subscription.getAdditionalChannelList());
		assertNotNull(subscription.getAdditionalServiceList());
	}
	
	@Test
	public void testSubscription_setterGetter() {
		Subscription subscription = new Subscription();
		subscription.setBasePack(Mockito.mock(BasePack.class));
		subscription.setDurationInMonths(12);
		assertNotNull(subscription.getBasePack());
		assertEquals(12, subscription.getDurationInMonths());
	}

}
