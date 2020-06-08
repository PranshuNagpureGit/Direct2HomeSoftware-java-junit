package com.techverito.sattv.menuhelper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.techverito.sattv.domain.Customer;
import com.techverito.sattv.exception.CustomException;
import com.techverito.sattv.menuoptioninput.RechargeAccountInput;
import com.techverito.sattv.service.CustomerService;
@ExtendWith(MockitoExtension.class)
public class RechargeAccountHelperTest {

	@Mock 
	AuthorizationHelper authHelper;
		
	@Mock 
	CustomerService customerService;
	
	@InjectMocks
	RechargeAccountHelper rechargeAccountHelper;
	
	
	@Test
	void testPerformRecharge_unauthorizedScenario() {
		Mockito.when(authHelper.getCurrentCustomer()).thenThrow(CustomException.class);
		assertThrows(CustomException.class, ()->rechargeAccountHelper.performRecharge(new RechargeAccountInput("10")));
	}
	
	
	@Test
	void testPerformRecharge_test() {
		Mockito.when(authHelper.getCurrentCustomer()).thenReturn(new Customer(1L, "abc"));
		Mockito.doNothing().when(customerService).updateCustomer(Mockito.any(Customer.class));
		assertEquals(600, rechargeAccountHelper.performRecharge(new RechargeAccountInput("500")).getCurrentBalance());
	}


}
