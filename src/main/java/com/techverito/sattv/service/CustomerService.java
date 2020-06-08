package com.techverito.sattv.service;


import com.techverito.sattv.database.DatabaseInstance;
import com.techverito.sattv.domain.Customer;

public class CustomerService {

	private DatabaseInstance dbInstance;
	
	public CustomerService() {
		this.dbInstance=DatabaseInstance.getInstance();
	}
	public Customer findByCustomerId(long customerId) {
		return dbInstance.getCustomerRecords().get(customerId);
	}
	
	public void updateCustomer(Customer customer) {
		dbInstance.getCustomerRecords().put(customer.getCustomerId(),customer);
	}

}
