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
@ExtendWith(MockitoExtension.class)
public class GetAccountBalanceHelperTest {

	@Mock
	AuthorizationHelper authHelper;
	
	@InjectMocks
	GetAccountBalanceHelper getAccountBalanceHelper;


	@Test
	public void testGetAccountBalance_success() {
		Customer customer = new Customer(1L,"abc");
		Mockito.when(authHelper.getCurrentCustomer()).thenReturn(customer);
		assertEquals(100, getAccountBalanceHelper.getAccountBalance().getBalance());
	}
	
	@Test
	public void testGetAccountBalance_failure() {
		Mockito.when(authHelper.getCurrentCustomer()).thenThrow(CustomException.class);
		assertThrows(CustomException.class, ()->getAccountBalanceHelper.getAccountBalance());
	}

}
