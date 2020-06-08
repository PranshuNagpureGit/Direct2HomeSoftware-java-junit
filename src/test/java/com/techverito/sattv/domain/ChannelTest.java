package com.techverito.sattv.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ChannelTest {
		
	@Test
	public void testChannel_constructor() {
		Channel channel= new Channel("abc",12);
		assertEquals("abc",channel.getName());
		assertEquals(12,channel.getAmount());
	}
	

}
