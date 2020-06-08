package com.techverito.sattv.menuoptionoutput;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.techverito.sattv.domain.BasePack;
import com.techverito.sattv.domain.Customer;

class SubscribeBasePackOutputTest {

	@Test
	void testSubscribeBasePackOutput_constructor() {
		BasePack basePack = new BasePack("SampleBasePack", 50, null);
		Customer customer = new Customer(1, "pword");
		customer.setAccountBalance(300);
		customer.setEmailId("pk@gmail.com");
		customer.setPhoneNumber("987654321");
		SubscribeBasePackOutput output=SubscribeBasePackOutput.getBuilder().withBasePack(basePack).
				withCustomer(customer).withDiscount(25).withDuration(2).
				withSubscriptionAmount(100).withFinalPrice(175).
				build();
		assertEquals(300,output.getAccountBalance());
		assertEquals("SampleBasePack",output.getBasePackName());
		assertEquals(25,output.getDiscountApplied());
		assertEquals(2,output.getDuration());
		assertEquals(175,output.getFinalPriceAfterDiscount());
		assertEquals(50,output.getMonthlyPrice());
		assertEquals(100,output.getSubscriptionAmount());
		assertEquals(2,output.getNotifications().size());
	}
	@Test
	void testSubscribeBasePackOutput_constructor_withoutEmailAndPassword() {
		BasePack basePack = new BasePack("SampleBasePack", 50, null);
		Customer customer = new Customer(1, "pword");
		customer.setAccountBalance(300);
		customer.setEmailId("");
		customer.setPhoneNumber("");
		SubscribeBasePackOutput output=SubscribeBasePackOutput.getBuilder().withBasePack(basePack).
				withCustomer(customer).withDiscount(25).withDuration(2).
				withSubscriptionAmount(100).withFinalPrice(175).
				build();
		assertEquals(300,output.getAccountBalance());
		assertEquals("SampleBasePack",output.getBasePackName());
		assertEquals(25,output.getDiscountApplied());
		assertEquals(2,output.getDuration());
		assertEquals(175,output.getFinalPriceAfterDiscount());
		assertEquals(50,output.getMonthlyPrice());
		assertEquals(100,output.getSubscriptionAmount());
		assertEquals(0,output.getNotifications().size());
	}
	@Test
	void testSubscribeBasePackOutput_constructor_withNullEmailAndPassword() {
		BasePack basePack = new BasePack("SampleBasePack", 50, null);
		Customer customer = new Customer(1, "pword");
		customer.setAccountBalance(300);
		customer.setEmailId(null);
		customer.setPhoneNumber(null);
		SubscribeBasePackOutput output=SubscribeBasePackOutput.getBuilder().withBasePack(basePack).
				withCustomer(customer).withDiscount(25).withDuration(2).
				withSubscriptionAmount(100).withFinalPrice(175).
				build();
		assertEquals(300,output.getAccountBalance());
		assertEquals("SampleBasePack",output.getBasePackName());
		assertEquals(25,output.getDiscountApplied());
		assertEquals(2,output.getDuration());
		assertEquals(175,output.getFinalPriceAfterDiscount());
		assertEquals(50,output.getMonthlyPrice());
		assertEquals(100,output.getSubscriptionAmount());
		assertEquals(0,output.getNotifications().size());
	}
	@Test
	void testToString_1() {
		BasePack basePack = new BasePack("SampleBasePack", 50, null);
		Customer customer = new Customer(1, "pword");
		customer.setAccountBalance(300);
		customer.setEmailId("pk@gmail.com");
		customer.setPhoneNumber("123456789");
		SubscribeBasePackOutput output=SubscribeBasePackOutput.getBuilder().withBasePack(basePack).
				withCustomer(customer).withDiscount(25).withDuration(2).
				withSubscriptionAmount(100).withFinalPrice(175).
				build();
		output.toString();
	}

}
