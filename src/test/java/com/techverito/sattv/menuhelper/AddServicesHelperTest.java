package com.techverito.sattv.menuhelper;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.techverito.sattv.domain.BasePack;
import com.techverito.sattv.domain.Channel;
import com.techverito.sattv.domain.Customer;
import com.techverito.sattv.domain.Subscription;
import com.techverito.sattv.exception.CustomException;
import com.techverito.sattv.menuoptioninput.AddChannelMenuInput;
import com.techverito.sattv.menuoptionoutput.AddChannelOutput;
import com.techverito.sattv.service.CustomerService;
import com.techverito.sattv.utils.Configuration;
@ExtendWith(MockitoExtension.class)
public class AddServicesHelperTest {

	@Mock 
	AuthorizationHelper authHelper;
		
	@Mock 
	CustomerService customerService;
	
	@InjectMocks
	AddChannelsHelper addChannelsHelper;
	
	
	@Test
	void testAddChannelsToSubscription_unauthorizedScenario() {
		Mockito.when(authHelper.getCurrentCustomer()).thenThrow(CustomException.class);
		assertThrows(CustomException.class, ()->addChannelsHelper.addChannelsToSubscription(Mockito.mock(AddChannelMenuInput.class)),Configuration.UNAUTHORIZED_ACCESS);
	}
	
	@Test
	void testAddChannelsToSubscription_basePackNotSubscribed_1() {
		Mockito.when(authHelper.getCurrentCustomer()).thenReturn(new Customer(1L, "abc"));
		assertThrows(CustomException.class, ()->addChannelsHelper.addChannelsToSubscription(Mockito.mock(AddChannelMenuInput.class)),Configuration.NO_BASE_PACK);
	}
	
	@Test
	void testAddChannelsToSubscription_basePackNotSubscribed_2() {
		Customer customer = new Customer(1L, "abc");
		customer.setSubscription(new Subscription());
		Mockito.when(authHelper.getCurrentCustomer()).thenReturn(customer);
		assertThrows(CustomException.class, ()->addChannelsHelper.addChannelsToSubscription(Mockito.mock(AddChannelMenuInput.class)),Configuration.NO_BASE_PACK);
	}
	
	@Test
	void testAddChannelsToSubscription_invalidInput() {
		Customer customer = new Customer(1L, "abc");
		Subscription subscription=new Subscription();
		subscription.setBasePack(new BasePack("SampleBase",12, null));
		customer.setSubscription(subscription);
		Mockito.when(authHelper.getCurrentCustomer()).thenReturn(customer);
		AddChannelMenuInput addChannelMenuInput = new AddChannelMenuInput("xxxx");
		CustomException exception = assertThrows(CustomException.class, ()->addChannelsHelper.addChannelsToSubscription(addChannelMenuInput));
		assertEquals(Configuration.INVALID_INPUT,exception.getMessage());
	}
	
	@Test
	void testAddChannelsToSubscription_insufficientFunds() {
		Customer customer = new Customer(1L, "abc");
		customer.setAccountBalance(0);
		Subscription subscription=new Subscription();
		subscription.setBasePack(new BasePack("SampleBase",12, null));
		customer.setSubscription(subscription);
		Mockito.when(authHelper.getCurrentCustomer()).thenReturn(customer);
		AddChannelMenuInput addChannelMenuInput = new AddChannelMenuInput("zee");
		CustomException exception = assertThrows(CustomException.class, ()->addChannelsHelper.addChannelsToSubscription(addChannelMenuInput));
		assertEquals(Configuration.INSUFFICIENT_FUNDS,exception.getMessage());
	}
	@Test
	void testAddChannelsToSubscription_alreadySubscribed() {
		Customer customer = new Customer(1L, "abc");
		Subscription subscription=new Subscription();
		subscription.setBasePack(new BasePack("SampleBase",12, null));
		subscription.getAdditionalChannelList().add(new Channel("Zee", 10));
		customer.setSubscription(subscription);
		Mockito.when(authHelper.getCurrentCustomer()).thenReturn(customer);
		AddChannelMenuInput addChannelMenuInput = new AddChannelMenuInput("zee");
		CustomException exception = assertThrows(CustomException.class, ()->addChannelsHelper.addChannelsToSubscription(addChannelMenuInput));
		assertEquals(Configuration.CHANNEL_ALREADY_SUBSCRIBED,exception.getMessage());
	}
	
	@Test
	void testAddChannelsToSubscription_success() {
		Customer customer = new Customer(1L, "abc");
		Subscription subscription=new Subscription();
		subscription.setBasePack(new BasePack("SampleBase",12, null));
		customer.setSubscription(subscription);
		Mockito.when(authHelper.getCurrentCustomer()).thenReturn(customer);
		AddChannelMenuInput addChannelMenuInput = new AddChannelMenuInput("zee");
		assertEquals(90,((AddChannelOutput)addChannelsHelper.addChannelsToSubscription(addChannelMenuInput)).getAccountBalance());
	}


}
