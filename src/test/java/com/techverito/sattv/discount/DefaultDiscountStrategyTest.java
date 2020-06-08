package com.techverito.sattv.discount;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.techverito.sattv.domain.BasePack;
import com.techverito.sattv.menuoptioninput.SubscribeBasePackInput;

class DefaultDiscountStrategyTest {

	@Test
	void testCalculateDiscount_1() {
		DefaultDiscountStrategy defaultDiscountStrategy = new DefaultDiscountStrategy();
		SubscribeBasePackInput input = new SubscribeBasePackInput("s", "5");
		input.setConcreteBasePack(new BasePack("Silver", 100, null));
		assertEquals(50, defaultDiscountStrategy.calculateDiscount(input));
		
	}
	
	@Test
	void testCalculateDiscount_2() {
		DefaultDiscountStrategy defaultDiscountStrategy = new DefaultDiscountStrategy();
		SubscribeBasePackInput input = new SubscribeBasePackInput("s", "2");
		input.setConcreteBasePack(new BasePack("Silver", 100, null));
		assertEquals(0, defaultDiscountStrategy.calculateDiscount(input));
	}
	
	@Test
	void testCalculateDiscount_3() {
		DefaultDiscountStrategy defaultDiscountStrategy = new DefaultDiscountStrategy();
		SubscribeBasePackInput input = new SubscribeBasePackInput("s", "3");
		input.setConcreteBasePack(new BasePack("Silver", 100, null));
		assertEquals(30, defaultDiscountStrategy.calculateDiscount(input));
	}

}
