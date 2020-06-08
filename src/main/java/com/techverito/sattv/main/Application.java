package com.techverito.sattv.main;

import java.util.Scanner;

import com.techverito.sattv.console.AbstractConsole;
import com.techverito.sattv.console.DefaultConsole;
import com.techverito.sattv.domain.AuthenticationInput;
import com.techverito.sattv.domain.Session;
import com.techverito.sattv.exception.CustomException;
import com.techverito.sattv.service.AuthenticationService;
import com.techverito.sattv.utils.ApplicationUtil;
import com.techverito.sattv.utils.Configuration;

public class Application {

	public static final Scanner inputScanner = new Scanner(System.in);

	public static void main(String[] args) {
		while (true) {
			try {
				AuthenticationInput authInput = getAuthenticationInputFromUser();
				if (authInput == null) {
					System.out.println("Invalid Input");
					continue;
				}
				AuthenticationService authService = new AuthenticationService();
				if (!authService.authenticate(authInput)) {
					System.out.println("Invalid Credentials");
					continue;
				}
				Session session = Session.getInstance();
				session.setCustomerId(authInput.getCustomerId());
				AbstractConsole console = new DefaultConsole();
				console.show();
			} catch(CustomException e) {
				ApplicationUtil.printMessage(Configuration.INVALID_CUSTOMER_ID);
			}catch (Exception e) {
				ApplicationUtil.printMessage(Configuration.UNEXPECTED_ERROR);
			}
		}
	}

	public static AuthenticationInput getAuthenticationInputFromUser() {
		long customerId=0L;
		ApplicationUtil.printMessage(Configuration.AUTH_HEADER);
		ApplicationUtil.printEmptyLines(1);
		System.out.println("1. Please enter customer id");
		String customerIdInString = inputScanner.next();
		try {
			customerId = Long.parseLong(customerIdInString);
		}
		catch(Exception e) {
			throw new CustomException(Configuration.INVALID_CUSTOMER_ID);
		}
		System.out.println("2. Please enter password");
		String password = inputScanner.next();
		AuthenticationInput authInput = new AuthenticationInput(customerId,password);
		return authInput;
	}

}
