package com.techverito.sattv.menuoption;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.techverito.sattv.exception.CustomException;
import com.techverito.sattv.main.Application;
import com.techverito.sattv.menuhelper.UpdateNotificationHelper;
import com.techverito.sattv.menuoptioninput.IMenuOptionInput;
import com.techverito.sattv.menuoptioninput.UpdateNotificationInput;
import com.techverito.sattv.menuoptionoutput.IMenuOptionOutput;
import com.techverito.sattv.menuoptionoutput.UpdateNotificationOutput;
import com.techverito.sattv.utils.ApplicationUtil;
import com.techverito.sattv.utils.Configuration;

public class UpdateNotificationMenuOption extends AbstractMenuOption{
	
	UpdateNotificationHelper updateNotificationHelper;
		
	public UpdateNotificationMenuOption() {
		setTitle(Configuration.UPDATE_NOTIFICATION_MENU_TITLE);
		this.updateNotificationHelper=new UpdateNotificationHelper();
	}
			
	@Override
	protected UpdateNotificationInput takeInputFromUser() {
		System.out.println("Enter the email");
		String emailId = Application.inputScanner.next();
		System.out.println("Enter the phone number");
		String phoneNumber=Application.inputScanner.next();
		return new UpdateNotificationInput(emailId,phoneNumber);
	}
	
	@Override
	protected void performInputValidation(IMenuOptionInput input) {
		UpdateNotificationInput updateNotificationInput = (UpdateNotificationInput)input;
		String emailRegex = Configuration.EMAIL_REGEX;
		Pattern emailPattern = Pattern.compile(emailRegex);
		Matcher emailMatcher = emailPattern.matcher(updateNotificationInput.getEmailId());
		if(!emailMatcher.matches()) {
			throw new CustomException(Configuration.INVALID_EMAIL);
		}
		String phoneNumberRegex = Configuration.PHONE_NUMBER_REGEX;
		Pattern numberPattern=Pattern.compile(phoneNumberRegex);
		Matcher numberMatcher = numberPattern.matcher(updateNotificationInput.getPhoneNumber());
		if(!numberMatcher.matches()) {
			throw new CustomException(Configuration.INVALID_PHONE_NUMBER);
		}
	}

	@Override
	protected UpdateNotificationOutput performBusinessLogic(IMenuOptionInput input) {
		return updateNotificationHelper.updateNotfication((UpdateNotificationInput)input);
	}

	@Override
	protected void printOutput(IMenuOptionOutput output) {
		ApplicationUtil.printMessage("Email and Phone updated successfully");
	}
}
