package com.techverito.sattv.menuhelper;

import com.techverito.sattv.domain.Customer;
import com.techverito.sattv.menuoptioninput.UpdateNotificationInput;
import com.techverito.sattv.menuoptionoutput.UpdateNotificationOutput;
import com.techverito.sattv.service.CustomerService;

public class UpdateNotificationHelper {
	
	AuthorizationHelper authHelper;
	CustomerService customerService;

	public UpdateNotificationHelper() {
		authHelper=new AuthorizationHelper();
		customerService=new CustomerService();
	}
	public UpdateNotificationOutput updateNotfication(UpdateNotificationInput input) {
		Customer customer  = authHelper.getCurrentCustomer();
		customer.setEmailId(input.getEmailId());
		customer.setPhoneNumber(input.getPhoneNumber());
		customerService.updateCustomer(customer);
		return new UpdateNotificationOutput(customer.getEmailId(), customer.getPhoneNumber());
	}

}
