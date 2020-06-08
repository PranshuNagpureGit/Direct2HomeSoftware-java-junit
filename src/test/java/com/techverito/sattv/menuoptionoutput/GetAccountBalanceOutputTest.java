package com.techverito.sattv.menuoptionoutput;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GetAccountBalanceOutputTest {

	@Test
	void testGetAccountBalanceOutput_constructor() {
		GetAccountBalanceOutput getAccountBalanceOutput = new GetAccountBalanceOutput(12);
		assertEquals(12, getAccountBalanceOutput.getBalance());
	}

}
