package com.techverito.sattv.menuoptionoutput;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RechargeAccountOutputTest {

	@Test
	void testRechargeAccountOutput_constructor() {
		RechargeAccountOutput rechargeAccountOutput = new RechargeAccountOutput(12);
		assertEquals(12, rechargeAccountOutput.getCurrentBalance());
	}

}
