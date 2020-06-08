package com.techverito.sattv.menuhelper;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.techverito.sattv.domain.Customer;
import com.techverito.sattv.domain.Subscription;
import com.techverito.sattv.exception.CustomException;
@ExtendWith(MockitoExtension.class)
public class ViewSubscriptionHelperTest {

	@Mock 
	AuthorizationHelper authHelper;
			
	@InjectMocks
	ViewSubscriptionHelper viewSubscriptionHelper;
	
	
	@Test
	void testUpdateNotification_unauthorizedScenario() {
		Mockito.when(authHelper.getCurrentCustomer()).thenThrow(CustomException.class);
		assertThrows(CustomException.class, ()->viewSubscriptionHelper.fetchCurrentSubscription());
	}
	
	
	@Test
	void testUpdateNotification_success() {
		Customer customer = new Customer(1L, "abc");
		customer.setSubscription(new Subscription());
		Mockito.when(authHelper.getCurrentCustomer()).thenReturn(customer);
		assertNotNull(viewSubscriptionHelper.fetchCurrentSubscription().getSubscription());
	}


}
