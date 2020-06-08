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
import com.techverito.sattv.domain.Session;
import com.techverito.sattv.exception.CustomException;
import com.techverito.sattv.service.CustomerService;
import com.techverito.sattv.utils.Configuration;

@ExtendWith(MockitoExtension.class)
public class AuthorizationHelperTest {

	@Mock
	CustomerService customerService;
	
	@InjectMocks
	AuthorizationHelper authorizationHelper;
	
	

	@Test
	public void testAuthorizationHelper_getCurentCustomer_unAuthorized() {
		assertThrows(CustomException.class, ()->authorizationHelper.getCurrentCustomer(),Configuration.UNAUTHORIZED_ACCESS);
	}
	
	@Test
	public void testAuthorizationHelper_getCurentCustomer_unAuthorized_2() {
		Session session = Session.getInstance();
		session.setCustomerId(0L);
		assertThrows(CustomException.class, ()->authorizationHelper.getCurrentCustomer(),Configuration.UNAUTHORIZED_ACCESS);
	}

	
	@Test
	public void testAuthorizationHelper_getCurentCustomer_customerNotFound() {
		Session session = Session.getInstance();
		session.setCustomerId(1L);
		Mockito.when(customerService.findByCustomerId(Mockito.anyLong())).thenReturn(null);
		assertThrows(CustomException.class, ()->authorizationHelper.getCurrentCustomer(),Configuration.UNAUTHORIZED_ACCESS);
	}
	
	
	@Test
	public void testAuthorizationHelper_getCurentCustomer_customerFound() {
		Session session = Session.getInstance();
		session.setCustomerId(1L);
		Mockito.when(customerService.findByCustomerId(Mockito.anyLong())).thenReturn(new Customer(1L,"abc"));
		assertEquals(1L, authorizationHelper.getCurrentCustomer().getCustomerId());
		assertEquals("abc", authorizationHelper.getCurrentCustomer().getPassword());
	}

}
