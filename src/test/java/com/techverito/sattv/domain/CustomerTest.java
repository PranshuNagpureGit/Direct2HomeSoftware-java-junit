package com.techverito.sattv.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CustomerTest {

	@Test
	public void testCustomer_constructor() {
		Customer customer = new Customer(100L, "abc");
		assertEquals(100L, customer.getCustomerId());
		assertEquals("abc", customer.getPassword());
		assertEquals(100, customer.getAccountBalance());
		assertNull(customer.getSubscription());
	}
	
	@Test
	public void testCustomer_setAccountBalance() {
		Customer customer = new Customer(100L, "abc");
		customer.setAccountBalance(200);
		assertEquals(200, customer.getAccountBalance());
	}
	@Test
	public void testCustomer_setSubscription() {
		Customer customer = new Customer(100L, "abc");
		customer.setSubscription(new Subscription());
		assertNotNull(customer.getSubscription());
	}
	@Test
	public void testCustomer_setEmailID() {
		Customer customer = new Customer(100L, "abc");
		customer.setEmailId("pk@gmail.com");
		assertEquals("pk@gmail.com", customer.getEmailId());
	}
	@Test
	public void testCustomer_setPhone() {
		Customer customer = new Customer(100L, "abc");
		customer.setPhoneNumber("987654321");
		assertEquals("987654321", customer.getPhoneNumber());
	}

}
