package com.techverito.sattv.menuoptioninput;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AddServiceMenuInputTest {

	@Test
	void testAddServiceMenuInput_constructor() {
		AddServiceMenuInput addServiceMenuInput = new AddServiceMenuInput("abc");
		assertEquals("abc", addServiceMenuInput.getServiceName());
	}

}
