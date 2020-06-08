package com.techverito.sattv.menuhelper;

import com.techverito.sattv.domain.Customer;
import com.techverito.sattv.menuoptionoutput.ViewSubscriptionOutput;

public class ViewSubscriptionHelper {

	AuthorizationHelper authHelper;
	
	public ViewSubscriptionHelper(){
		authHelper=new AuthorizationHelper();
	}
	public ViewSubscriptionOutput fetchCurrentSubscription() {
		Customer customer  = authHelper.getCurrentCustomer();
		return new ViewSubscriptionOutput(customer.getSubscription());
	}

}
