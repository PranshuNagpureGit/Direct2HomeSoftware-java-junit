package com.techverito.sattv.utils;

public class Configuration {
	
	//public final static String CONSOLE_SEPARATOR="##################################";
	public static final String CONSOLE_HEADER="############################### WELCOME TO SAT TV ################################";
	public static final String AUTH_HEADER="################################## AUTHENTICATION PAGE ###############################";
	public static final String SELECT_OPTION = "Enter the option";
	public static final String INVALID_OPTION = "Invalid option";
	public static final String UNEXPECTED_ERROR = "Unexpected exception has occured";
	public static final String UNAUTHORIZED_ACCESS = "Access is unauthorized";
	public static final String CUSTOMER_NOT_FOUND = "Customer does not exists";
	public static final String INVALID_CUSTOMER_ID = "Invalid Customer ID";
	public static final String INVALID_AMOUNT = "Invalid Amount";
	public static final String INVALID_MONTHS = "Please enter duration between 1 and 12";
	public static final String ALREADY_SUBSCRIBED_TO_BASE_PACK = "You have an existing Base Pack";
	public static final String INSUFFICIENT_FUNDS = "Insufficient Funds.Please recharge.";
	public static final String INVALID_INPUT = "Invalid Input.";
	public static final String NO_BASE_PACK = "Please subscribe to a base pack first";
	public static final String ALREADY_SUBSCRIBED_TO_SERVICE = "Service is already subscribed";
	public static final String CHANNEL_ALREADY_SUBSCRIBED = "Channel is already subscribed";
	public static final String SERVICE_NOT_FOUND = "Entered service not found";
	public static final String EMPTY_INPUT = "Input is empty";
	public static final String INVALID_BASE_PACK = "Please enter a valid base pack";
	public static final String INVALID_DURATION = "Please enter a valid duration";
	public static final String INVALID_EMAIL = "Please enter a valid email";
	public static final String INVALID_PHONE_NUMBER = "Please enter a valid phone number";
	
	public static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";
	public static final String PHONE_NUMBER_REGEX = "(0/91)?[7-9][0-9]{9}";
	public static final int SUB_DURATION_MIN_LIMIT = 0;
	public static final int SUB_DURATION_MAX_LIMIT = 12;
	public static final double RECHARGE_AMT_MIN_LIMIT = 0;
	public static final double RECHARGE_AMT_MAX_LIMIT = 100000;
	public static final int EXIT_OPTION = 9;

	
	public static final String UPDATE_NOTIFICATION_MENU_TITLE = "Update email and phone number for notifications";
	public static final String ADD_CHANNEL_MENU_TITLE = "Add channels to existing subscription";
	public static final String ADD_SERVICES_MENU_TITLE = "Subscribe to special services";
	public static final String GET_ACCOUNT_BALANCE_MENU_TITLE = "View current balance in the account";
	public static final String RECHARGE_MENU_TITLE = "Recharge Account";
	public static final String VIEW_ALL_PACKS_MENU_TITLE = "View available packs,channels and services";
	public static final String VIEW_SUBSCRIPTION_MENU_TITLE = "View current subscription details";
	public static final String SUBSCRIBE_BASE_PACK_MENU_TITLE = "Subscribe to channel packs";
}
