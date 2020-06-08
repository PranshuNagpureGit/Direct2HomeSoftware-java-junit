package com.techverito.sattv.discount;

import com.techverito.sattv.menuoptioninput.SubscribeBasePackInput;

public interface IDiscountStrategy {
	
	public abstract double calculateDiscount(SubscribeBasePackInput input);
}
