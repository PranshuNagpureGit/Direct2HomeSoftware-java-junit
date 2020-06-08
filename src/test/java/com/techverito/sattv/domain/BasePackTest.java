package com.techverito.sattv.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class BasePackTest {
		
	@Test
	public void testBasePack_constructor() {
		List<Channel> channels = new ArrayList<Channel>();
		BasePack basePack = new BasePack("abc",12,channels);
		assertEquals("abc",basePack.getName());
		assertEquals(12,basePack.getAmount());
		assertNotNull(basePack.getChannelList());
	}
	

}
