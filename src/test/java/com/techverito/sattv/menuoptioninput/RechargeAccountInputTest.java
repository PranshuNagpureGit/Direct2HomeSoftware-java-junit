package com.techverito.sattv.menuoptioninput;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RechargeAccountInputTest {

	@Test
	void testRechargeAccountInput_constructor() {
		RechargeAccountInput rechargeAccountInput = new RechargeAccountInput("10");
		assertEquals("10", rechargeAccountInput.getRechargeAmount());
	}

}
