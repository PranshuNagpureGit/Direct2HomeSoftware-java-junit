package com.techverito.sattv.service;

import com.techverito.sattv.domain.AuthenticationInput;
import com.techverito.sattv.domain.Customer;

public class AuthenticationService {

	private CustomerService customerService;

	public AuthenticationService() {
		this.customerService = new CustomerService();
	}

	public boolean authenticate(AuthenticationInput authInput) {
		Customer customer = customerService.findByCustomerId(authInput.getCustomerId());
		if (customer == null) {
			return false;
		}
		if (!customer.getPassword().equals(authInput.getPassword())) {
			return false;
		}
		return true;
	}
}
