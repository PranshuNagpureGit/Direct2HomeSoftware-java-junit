package com.techverito.sattv.menuhelper;

import com.techverito.sattv.domain.Customer;
import com.techverito.sattv.menuoptionoutput.GetAccountBalanceOutput;

public class GetAccountBalanceHelper {

	AuthorizationHelper authorizationHelper;

	public GetAccountBalanceHelper() {
		this.authorizationHelper = new AuthorizationHelper();
	}

	public GetAccountBalanceOutput getAccountBalance() {
		Customer customer = authorizationHelper.getCurrentCustomer();
		return new GetAccountBalanceOutput(customer.getAccountBalance());
	}

}
