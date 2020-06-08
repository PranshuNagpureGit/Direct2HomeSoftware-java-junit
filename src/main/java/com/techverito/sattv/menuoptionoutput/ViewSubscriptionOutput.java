package com.techverito.sattv.menuoptionoutput;

import com.techverito.sattv.domain.Subscription;

public class ViewSubscriptionOutput implements IMenuOptionOutput {
	Subscription subscription;

	public Subscription getSubscription() {
		return subscription;
	}

	public ViewSubscriptionOutput(Subscription subscription) {
		super();
		this.subscription = subscription;
	}

}
