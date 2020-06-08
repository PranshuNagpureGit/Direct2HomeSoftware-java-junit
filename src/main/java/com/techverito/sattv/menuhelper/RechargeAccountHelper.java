package com.techverito.sattv.menuhelper;

import com.techverito.sattv.domain.Customer;
import com.techverito.sattv.menuoptioninput.RechargeAccountInput;
import com.techverito.sattv.menuoptionoutput.RechargeAccountOutput;
import com.techverito.sattv.service.CustomerService;

public class RechargeAccountHelper {

	private AuthorizationHelper authorizationHelper;
	private CustomerService customerService;

	public RechargeAccountHelper() {
		this.authorizationHelper = new AuthorizationHelper();
		this.customerService = new CustomerService();
	}

	public RechargeAccountOutput performRecharge(RechargeAccountInput input) {
		Customer customer = authorizationHelper.getCurrentCustomer();
		customer.setAccountBalance(customer.getAccountBalance() + Double.parseDouble(input.getRechargeAmount()));
		customerService.updateCustomer(customer);
		return new RechargeAccountOutput(customer.getAccountBalance());

	}

}
