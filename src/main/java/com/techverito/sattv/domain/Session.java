package com.techverito.sattv.domain;

public final class Session {
	
	private long customerId;
	private static Session instance;

	private Session() {
	}
	
	public static Session getInstance() {
		if(instance==null) {
			instance=new Session();
		}
		return instance;
	}
	
	 public void setCustomerId(Long customerId) {
		this.customerId=customerId;
	 }
	 
	 public long getCustomerId() {
		 return customerId;
	 }

}
