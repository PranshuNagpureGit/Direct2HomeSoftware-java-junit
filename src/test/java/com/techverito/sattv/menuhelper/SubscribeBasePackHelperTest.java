package com.techverito.sattv.menuhelper;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.techverito.sattv.discount.IDiscountStrategy;
import com.techverito.sattv.domain.BasePack;
import com.techverito.sattv.domain.Customer;
import com.techverito.sattv.domain.Subscription;
import com.techverito.sattv.exception.CustomException;
import com.techverito.sattv.menuoptioninput.SubscribeBasePackInput;
import com.techverito.sattv.menuoptionoutput.SubscribeBasePackOutput;
import com.techverito.sattv.service.BasePackService;
import com.techverito.sattv.service.CustomerService;
import com.techverito.sattv.utils.Configuration;
@ExtendWith(MockitoExtension.class)
public class SubscribeBasePackHelperTest {

	@Mock 
	AuthorizationHelper authHelper;
	
	@Mock 
	IDiscountStrategy discountStrategy;
	
	@Spy 
	BasePackService basePackService;
		
	@Mock 
	CustomerService customerService;
	
	@InjectMocks
	SubscribeBasePackHelper subscribeBasePackHelper;
	
	
	@Test
	void testSubscribeBasePack_unauthorizedScenario() {
		SubscribeBasePackInput subscribeBasePackInput = new SubscribeBasePackInput("s","1");
		Mockito.when(authHelper.getCurrentCustomer()).thenThrow(CustomException.class);
		assertThrows(CustomException.class, ()->subscribeBasePackHelper.subscribeBasePack(subscribeBasePackInput),Configuration.UNAUTHORIZED_ACCESS);
	}
	
	@Test
	void testSubscribeBasePack_basePackAlreadySubscribed_1() {
		SubscribeBasePackInput subscribeBasePackInput = new SubscribeBasePackInput("s","1");
		Customer customer = new Customer(1L, "abc");
		Subscription subscription=new Subscription();
		subscription.setBasePack(new BasePack("SampleBase",12, null));
		customer.setSubscription(subscription);
		Mockito.when(authHelper.getCurrentCustomer()).thenReturn(customer);
		assertThrows(CustomException.class, ()->subscribeBasePackHelper.subscribeBasePack(subscribeBasePackInput),Configuration.ALREADY_SUBSCRIBED_TO_BASE_PACK);
	}
		
	@Test
	void testSubscribeBasePack_insufficientFunds() {
		Customer customer = new Customer(1L, "abc");
		customer.setSubscription(new Subscription());
		customer.setAccountBalance(0);
		Mockito.when(authHelper.getCurrentCustomer()).thenReturn(customer);
		SubscribeBasePackInput subscribeBasePackInput = new SubscribeBasePackInput("s","1");
		assertThrows(CustomException.class, ()->subscribeBasePackHelper.subscribeBasePack(subscribeBasePackInput),Configuration.INSUFFICIENT_FUNDS);
	}
	
	
	@Test
	void testAddChannelsToSubscription_success_silver() {
		Customer customer = new Customer(1L, "abc");
		customer.setSubscription(new Subscription());
		Mockito.when(authHelper.getCurrentCustomer()).thenReturn(customer);
		SubscribeBasePackInput subscribeBasePackInput = new SubscribeBasePackInput("s","1");
		assertEquals(50,((SubscribeBasePackOutput)subscribeBasePackHelper.subscribeBasePack(subscribeBasePackInput)).getAccountBalance());
	}
	
	@Test
	void testAddChannelsToSubscription_success_gold() {
		Customer customer = new Customer(1L, "abc");
		Mockito.when(authHelper.getCurrentCustomer()).thenReturn(customer);
		SubscribeBasePackInput subscribeBasePackInput = new SubscribeBasePackInput("g","1");
		assertEquals(0,((SubscribeBasePackOutput)subscribeBasePackHelper.subscribeBasePack(subscribeBasePackInput)).getAccountBalance());
	}

}
