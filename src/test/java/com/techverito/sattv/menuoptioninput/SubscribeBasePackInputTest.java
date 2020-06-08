package com.techverito.sattv.menuoptioninput;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.techverito.sattv.domain.BasePack;

class SubscribeBasePackInputTest {

	@Test
	void testSubscribeBasePackInput_constructor() {
		SubscribeBasePackInput subscribeBasePackInput = new SubscribeBasePackInput("s","3");
		assertEquals("3", subscribeBasePackInput.getDurationInMonths());
		assertEquals("s", subscribeBasePackInput.getSelectedBasePack());
	}
	@Test
	void testSubscribeBasePackInput_setBasePack() {
		SubscribeBasePackInput subscribeBasePackInput = new SubscribeBasePackInput("s","3");
		subscribeBasePackInput.setConcreteBasePack(Mockito.mock(BasePack.class));
		assertNotNull(subscribeBasePackInput.getConcreteBasePack());
	}
}
