package com.techverito.sattv.menuhelper;

import java.util.List;
import java.util.stream.Collectors;

import com.techverito.sattv.database.DatabaseInstance;
import com.techverito.sattv.domain.AdditionalService;
import com.techverito.sattv.domain.Customer;
import com.techverito.sattv.exception.CustomException;
import com.techverito.sattv.menuoptioninput.AddServiceMenuInput;
import com.techverito.sattv.menuoptionoutput.AddServiceOutput;
import com.techverito.sattv.menuoptionoutput.IMenuOptionOutput;
import com.techverito.sattv.service.CustomerService;
import com.techverito.sattv.utils.Configuration;

public class AddServicesHelper {

	CustomerService customerService;
	AuthorizationHelper authHelper;
	
	public AddServicesHelper() {
		customerService =  new CustomerService();
		authHelper = new AuthorizationHelper();
	}
	
	public IMenuOptionOutput addService(AddServiceMenuInput input) {
		
		Customer customer = authHelper.getCurrentCustomer();
		if(customer.getSubscription()==null || customer.getSubscription().getBasePack()==null) {
			throw new CustomException(Configuration.NO_BASE_PACK);
		}
		AdditionalService selectedService = getServiceFromServiceName(input.getServiceName());
		validateIfServiceAlreadySubscribed(customer,input.getServiceName());
		validateFundsAvailability(customer,selectedService);
		customer.getSubscription().getAdditionalServiceList().add(selectedService);
		customer.setAccountBalance(customer.getAccountBalance()-selectedService.getAmount());
		customerService.updateCustomer(customer);
		return new AddServiceOutput(customer.getAccountBalance());
	}

	public AdditionalService getServiceFromServiceName(String serviceName) {
		List<AdditionalService> allServices = DatabaseInstance.getInstance().getAdditionalServices();
		List<AdditionalService> selectedService = allServices.stream().filter((service) -> {
			if(service.getName().equalsIgnoreCase(serviceName)) {
				return true;
			}else {
				return false;
			}
		}).collect(Collectors.toList());
		if(selectedService.isEmpty()) {
			throw new CustomException(Configuration.SERVICE_NOT_FOUND);
		}
		return selectedService.get(0);
	}
	
	public void validateIfServiceAlreadySubscribed(Customer customer, String serviceName) {
		boolean doesServiceExists= customer.getSubscription().getAdditionalServiceList().stream().anyMatch((service)->{
			return service.getName().equalsIgnoreCase(serviceName);
		});
		if(doesServiceExists) {
			throw new CustomException(Configuration.ALREADY_SUBSCRIBED_TO_SERVICE);
		}
	}
	public void validateFundsAvailability(Customer customer, AdditionalService selectedService) {
		if(customer.getAccountBalance()<selectedService.getAmount()) {
			throw new CustomException(Configuration.INSUFFICIENT_FUNDS);
		}
	}



}
