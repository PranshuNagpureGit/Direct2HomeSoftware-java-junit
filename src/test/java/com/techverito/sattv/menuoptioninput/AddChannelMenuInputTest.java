package com.techverito.sattv.menuoptioninput;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AddChannelMenuInputTest {

	@Test
	void testAddChannelMenuInput_constructor() {
		AddChannelMenuInput addChannelMenuInput = new AddChannelMenuInput("abc,def");
		assertEquals("abc,def", addChannelMenuInput.getCommaSeparatedChannels());
	}

}
