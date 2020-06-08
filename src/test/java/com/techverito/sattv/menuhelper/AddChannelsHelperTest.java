package com.techverito.sattv.menuhelper;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.techverito.sattv.domain.AdditionalService;
import com.techverito.sattv.domain.BasePack;
import com.techverito.sattv.domain.Customer;
import com.techverito.sattv.domain.Subscription;
import com.techverito.sattv.exception.CustomException;
import com.techverito.sattv.menuoptioninput.AddServiceMenuInput;
import com.techverito.sattv.menuoptionoutput.AddServiceOutput;
import com.techverito.sattv.service.CustomerService;
import com.techverito.sattv.utils.Configuration;
@ExtendWith(MockitoExtension.class)
public class AddChannelsHelperTest {

	@Mock 
	AuthorizationHelper authHelper;
		
	@Mock 
	CustomerService customerService;
	
	@InjectMocks
	AddServicesHelper addServicesHelper;
	
	
	@Test
	void testServicesToSubscription_unauthorizedScenario() {
		Mockito.when(authHelper.getCurrentCustomer()).thenThrow(CustomException.class);
		assertThrows(CustomException.class, ()->addServicesHelper.addService(Mockito.mock(AddServiceMenuInput.class)),Configuration.UNAUTHORIZED_ACCESS);
	}
	
	@Test
	void testServicesToSubscription_basePackNotSubscribed_1() {
		Mockito.when(authHelper.getCurrentCustomer()).thenReturn(new Customer(1L, "abc"));
		assertThrows(CustomException.class, ()->addServicesHelper.addService(Mockito.mock(AddServiceMenuInput.class)),Configuration.NO_BASE_PACK);
	}
	
	@Test
	void testServicesToSubscription_basePackNotSubscribed_2() {
		Customer customer = new Customer(1L, "abc");
		customer.setSubscription(new Subscription());
		Mockito.when(authHelper.getCurrentCustomer()).thenReturn(customer);
		assertThrows(CustomException.class, ()->addServicesHelper.addService(Mockito.mock(AddServiceMenuInput.class)),Configuration.NO_BASE_PACK);
	}
	
	@Test
	void testAddChannelsToSubscription_serviceNotFound() {
		Customer customer = new Customer(1L, "abc");
		Subscription subscription=new Subscription();
		subscription.setBasePack(new BasePack("SampleBase",12, null));
		customer.setSubscription(subscription);
		Mockito.when(authHelper.getCurrentCustomer()).thenReturn(customer);
		AddServiceMenuInput addServiceMenuInput = new AddServiceMenuInput("xxxx");
		CustomException exception = assertThrows(CustomException.class, ()->addServicesHelper.addService(addServiceMenuInput));
		assertEquals(Configuration.SERVICE_NOT_FOUND,exception.getMessage());
	}
	
	
	@Test
	void testAddChannelsToSubscription_alreadySubscribed() {
		Customer customer = new Customer(1L, "abc");
		Subscription subscription=new Subscription();
		subscription.setBasePack(new BasePack("SampleBase",12, null));
		subscription.getAdditionalServiceList().add(new AdditionalService("LearnCooking", 100));
		customer.setSubscription(subscription);
		Mockito.when(authHelper.getCurrentCustomer()).thenReturn(customer);
		AddServiceMenuInput addServiceMenuInput = new AddServiceMenuInput("LearnCooking");
		CustomException exception = assertThrows(CustomException.class, ()->addServicesHelper.addService(addServiceMenuInput));
		assertEquals(Configuration.ALREADY_SUBSCRIBED_TO_SERVICE,exception.getMessage());
	}
	@Test
	void testAddChannelsToSubscription_insufficientFunds() {
		Customer customer = new Customer(1L, "abc");
		customer.setAccountBalance(0);
		Subscription subscription=new Subscription();
		subscription.setBasePack(new BasePack("SampleBase",12, null));
		customer.setSubscription(subscription);
		Mockito.when(authHelper.getCurrentCustomer()).thenReturn(customer);
		AddServiceMenuInput addServiceMenuInput = new AddServiceMenuInput("LearnCooking");
		CustomException exception = assertThrows(CustomException.class, ()->addServicesHelper.addService(addServiceMenuInput));
		assertEquals(Configuration.INSUFFICIENT_FUNDS,exception.getMessage());
	}
	@Test
	void testAddChannelsToSubscription_success() {
		Customer customer = new Customer(1L, "abc");
		Subscription subscription=new Subscription();
		subscription.setBasePack(new BasePack("SampleBase",12, null));
		customer.setSubscription(subscription);
		customer.setAccountBalance(500);
		Mockito.when(authHelper.getCurrentCustomer()).thenReturn(customer);
		AddServiceMenuInput addServiceMenuInput = new AddServiceMenuInput("LearnCooking");
		assertEquals(400,((AddServiceOutput)addServicesHelper.addService(addServiceMenuInput)).getAccountBalance());
	}


}
