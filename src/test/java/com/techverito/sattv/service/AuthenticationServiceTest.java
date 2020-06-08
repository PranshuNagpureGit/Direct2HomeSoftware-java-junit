package com.techverito.sattv.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.techverito.sattv.domain.AuthenticationInput;
import com.techverito.sattv.domain.Customer;

@ExtendWith(MockitoExtension.class)
class AuthenticationServiceTest {

	@Mock
	CustomerService customerService;
	
	@InjectMocks
	AuthenticationService authService;
	
	@BeforeEach
	public void setUp() {
		Mockito.when(customerService.findByCustomerId(Mockito.anyLong())).thenReturn(new Customer(1L,"abc"));
	}
	
	@Test
	void testAuthenticate_customerIDDoesNotExists() {
		Mockito.when(customerService.findByCustomerId(Mockito.anyLong())).thenReturn(null);
		AuthenticationInput authInput = new AuthenticationInput(100L,"abc");
		assertFalse(authService.authenticate(authInput));
	}
	@Test
	void testAuthenticate_customerPasswordDoesNotMatch() {
		AuthenticationInput authInput = new AuthenticationInput(1L,"def");
		assertFalse(authService.authenticate(authInput));
	}
	
	@Test
	void testAuthenticate_success() {
		AuthenticationInput authInput = new AuthenticationInput(1L,"abc");
		assertTrue(authService.authenticate(authInput));
	}

}
