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
import com.techverito.sattv.menuoptioninput.UpdateNotificationInput;
import com.techverito.sattv.service.CustomerService;
@ExtendWith(MockitoExtension.class)
public class UpdateNotificationHelperTest {

	@Mock 
	AuthorizationHelper authHelper;
		
	@Mock 
	CustomerService customerService;
	
	@InjectMocks
	UpdateNotificationHelper updateNotificationHelper;
	
	
	@Test
	void testUpdateNotification_unauthorizedScenario() {
		UpdateNotificationInput updateNotificationInput = new UpdateNotificationInput("pk@gmail.com", "987654321");
		Mockito.when(authHelper.getCurrentCustomer()).thenThrow(CustomException.class);
		assertThrows(CustomException.class, ()->updateNotificationHelper.updateNotfication(updateNotificationInput));
	}
	
	
	@Test
	void testUpdateNotification_success() {
		UpdateNotificationInput updateNotificationInput = new UpdateNotificationInput("pk@gmail.com", "987654321");
		Mockito.when(authHelper.getCurrentCustomer()).thenReturn(new Customer(1L, "abc"));
		Mockito.doNothing().when(customerService).updateCustomer(Mockito.any(Customer.class));
		assertEquals("pk@gmail.com", updateNotificationHelper.updateNotfication(updateNotificationInput).getEmailId());
		assertEquals("987654321", updateNotificationHelper.updateNotfication(updateNotificationInput).getPhoneNumber());
	}


}
