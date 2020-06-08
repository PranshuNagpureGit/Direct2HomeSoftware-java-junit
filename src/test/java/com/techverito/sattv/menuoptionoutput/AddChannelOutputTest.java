package com.techverito.sattv.menuoptionoutput;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AddChannelOutputTest {

	@Test
	void testAddChannelOutput_constructor() {
		AddChannelOutput addChannelOutput = new AddChannelOutput(12);
		assertEquals(12, addChannelOutput.getAccountBalance());
	}

}
