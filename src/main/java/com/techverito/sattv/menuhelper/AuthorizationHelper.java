package com.techverito.sattv.menuhelper;

import com.techverito.sattv.domain.Customer;
import com.techverito.sattv.domain.Session;
import com.techverito.sattv.exception.CustomException;
import com.techverito.sattv.service.CustomerService;
import com.techverito.sattv.utils.Configuration;

public class AuthorizationHelper {
	
	private CustomerService customerService;
	
	public AuthorizationHelper() {
		this.customerService = new CustomerService();
	}
	public Customer getCurrentCustomer() {
		long customerId = Session.getInstance().getCustomerId();
		if(customerId==0) {
			throw new CustomException(Configuration.UNAUTHORIZED_ACCESS);
		}else {
			Customer customer = customerService.findByCustomerId(customerId);
			if(customer==null) {
				throw new CustomException(Configuration.CUSTOMER_NOT_FOUND);
			}else {
				return customer;
			}
		}
	}
}
