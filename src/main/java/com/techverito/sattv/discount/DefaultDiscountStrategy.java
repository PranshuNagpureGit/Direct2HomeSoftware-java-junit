package com.techverito.sattv.discount;

import com.techverito.sattv.menuoptioninput.SubscribeBasePackInput;

public class DefaultDiscountStrategy implements IDiscountStrategy{
	
	private final double discountPercent = 10;

	@Override
	public double calculateDiscount(SubscribeBasePackInput input) {
		if(Integer.parseInt(input.getDurationInMonths()) >= 3) {
			return (double)(input.getConcreteBasePack().getAmount())*(discountPercent)*(Integer.parseInt(input.getDurationInMonths()))/(double)100;
		}
		return 0;
	}
	

}
