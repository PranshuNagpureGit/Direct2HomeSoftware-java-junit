package com.techverito.sattv.menuhelper;

import com.techverito.sattv.discount.IDiscountStrategy;
import com.techverito.sattv.domain.BasePack;
import com.techverito.sattv.domain.Customer;
import com.techverito.sattv.domain.Subscription;
import com.techverito.sattv.exception.CustomException;
import com.techverito.sattv.menuoptioninput.SubscribeBasePackInput;
import com.techverito.sattv.menuoptionoutput.IMenuOptionOutput;
import com.techverito.sattv.menuoptionoutput.SubscribeBasePackOutput;
import com.techverito.sattv.service.BasePackService;
import com.techverito.sattv.service.CustomerService;
import com.techverito.sattv.utils.Configuration;

public class SubscribeBasePackHelper {

	private IDiscountStrategy discountStrategy;
	private BasePackService basePackService;
	private CustomerService customerService;
	private AuthorizationHelper authorizationHelper;

	public SubscribeBasePackHelper(IDiscountStrategy strategy) {
		this.discountStrategy = strategy;
		this.basePackService = new BasePackService();
		this.authorizationHelper = new AuthorizationHelper();
		this.customerService = new CustomerService();
	}

	public IMenuOptionOutput subscribeBasePack(SubscribeBasePackInput subscriberBasePackInput) {
		int duration = Integer.parseInt(subscriberBasePackInput.getDurationInMonths());
		Customer customer = authorizationHelper.getCurrentCustomer();
		validateIfAlreadySubscribed(customer);
		BasePack basePack = fetchBasePackFromDB(subscriberBasePackInput.getSelectedBasePack());
		subscriberBasePackInput.setConcreteBasePack(basePack);
		double discount = discountStrategy.calculateDiscount(subscriberBasePackInput);
		double subscriptionCost = (basePack.getAmount()) * (duration);
		double finalCost = subscriptionCost - discount;
		validateFunds(customer, finalCost);
		Subscription subscription = null;
		if (customer.getSubscription() == null) {
			subscription = new Subscription();
		} else {
			subscription = customer.getSubscription();
		}
		subscription.setBasePack(basePack);
		subscription.setDurationInMonths(duration);
		customer.setSubscription(subscription);
		customer.setAccountBalance(customer.getAccountBalance() - finalCost);
		customerService.updateCustomer(customer);

		return SubscribeBasePackOutput.getBuilder().withBasePack(basePack)
				.withDuration(duration).withCustomer(customer)
				.withDiscount(discount).withFinalPrice(finalCost)
				.withSubscriptionAmount(subscriptionCost).build();
	}

	
	private void validateFunds(Customer customer, double finalCost) {
		if (customer.getAccountBalance() < finalCost) {
			throw new CustomException(Configuration.INSUFFICIENT_FUNDS);
		}
	}

	private BasePack fetchBasePackFromDB(String selectedBasePack) {
		String basePackTitle = (selectedBasePack.equalsIgnoreCase("s")) ? "Silver": "Gold";
		BasePack basePack = basePackService.fetchBasePack(basePackTitle);
		return basePack;
	}

	public void validateIfAlreadySubscribed(Customer customer) {
		if (customer.getSubscription() != null && customer.getSubscription().getBasePack() != null) {
			throw new CustomException(Configuration.ALREADY_SUBSCRIBED_TO_BASE_PACK);
		}
		
	}


}
