package com.techverito.sattv.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.techverito.sattv.database.DatabaseInstance;
import com.techverito.sattv.domain.Customer;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

	@Mock
	DatabaseInstance dbInstance;
	
	@InjectMocks
	CustomerService customerService;
	
	@BeforeEach
	public void setUp() {
		HashMap<Long, Customer> customerRecordMap = new HashMap<Long, Customer>();
		Customer expectedCustomer = new Customer(1,"abc");
		customerRecordMap.put((long) 1, expectedCustomer);
		Mockito.when(dbInstance.getCustomerRecords()).thenReturn(customerRecordMap);
	}
	
	@Test
	public void test_findByCustomerId_NotFound() {		
		assertNull(customerService.findByCustomerId(10));
	}
	
	@Test
	public void test_findByCustomerId_found() {
		assertNotNull(customerService.findByCustomerId(1));
		assertEquals("abc",customerService.findByCustomerId(1).getPassword());
	}
	
	@Test
	public void test_updateCustomer() {
		Customer updatedCustomer = new Customer(1,"def");
		customerService.updateCustomer(updatedCustomer);
		assertEquals("def",customerService.findByCustomerId(1L).getPassword());
	}

}
