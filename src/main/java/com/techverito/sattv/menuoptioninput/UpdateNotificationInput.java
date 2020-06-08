package com.techverito.sattv.menuoptioninput;

public class UpdateNotificationInput implements IMenuOptionInput {

	private String emailId;
	private String phoneNumber;
	public UpdateNotificationInput(String emailId, String phoneNumber) {
		this.emailId=emailId;
		this.phoneNumber=phoneNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}

}
