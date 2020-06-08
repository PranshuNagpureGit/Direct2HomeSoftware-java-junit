package com.techverito.sattv.util;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.techverito.sattv.utils.ApplicationUtil;

class ApplicationUtilTest {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;

	@BeforeEach
	public void beforeAll() {
		System.setOut(new PrintStream(outContent));
	}
	@Test
	void test_messagePrint() {
		String message="Hello World";
		ApplicationUtil.printMessage(message);
		assertEquals("Hello World\r\n",outContent.toString());
		
	}
	@Test
	void test_printEmptyLines() {
		int lines=2;
		ApplicationUtil.printEmptyLines(lines);
		assertEquals("\r\n\r\n",outContent.toString());
		
	}
	@AfterEach
	public void afterAll() {
		System.setOut(originalOut);
	}
}
