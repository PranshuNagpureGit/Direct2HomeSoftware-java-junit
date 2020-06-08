package com.techverito.sattv.menuoptionoutput;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AddServiceOutputTest {

	@Test
	void testAddServiceOutput_constructor() {
		AddServiceOutput addServiceOutput = new AddServiceOutput(12);
		assertEquals(12, addServiceOutput.getAccountBalance());
	}

}
