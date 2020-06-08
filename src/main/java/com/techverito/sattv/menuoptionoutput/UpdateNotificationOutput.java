package com.techverito.sattv.menuoptionoutput;

public class UpdateNotificationOutput implements IMenuOptionOutput {
	private String emailId;
	private String phoneNumber;
	
	public String getEmailId() {
		return emailId;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public UpdateNotificationOutput(String emailId, String phoneNumber) {
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
	}

}
