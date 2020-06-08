package com.techverito.sattv.menuhelper;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.techverito.sattv.database.DatabaseInstance;
import com.techverito.sattv.domain.Channel;
import com.techverito.sattv.domain.Customer;
import com.techverito.sattv.exception.CustomException;
import com.techverito.sattv.menuoptioninput.AddChannelMenuInput;
import com.techverito.sattv.menuoptionoutput.AddChannelOutput;
import com.techverito.sattv.menuoptionoutput.IMenuOptionOutput;
import com.techverito.sattv.service.CustomerService;
import com.techverito.sattv.utils.Configuration;

public class AddChannelsHelper {
	
	CustomerService customerService;
	AuthorizationHelper authHelper;
	
	public AddChannelsHelper() {
		customerService =  new CustomerService();
		authHelper = new AuthorizationHelper();
	}
	public IMenuOptionOutput addChannelsToSubscription(AddChannelMenuInput input) {
		
		Customer customer = authHelper.getCurrentCustomer();
		validateIfBasePackSubscribed(customer);
		String[] channelNames = input.getCommaSeparatedChannels().split(",");
		List<Channel>selectedChannels = getChannelListFromChannelName(channelNames);
		if(selectedChannels.size() != channelNames.length) {
			throw new CustomException(Configuration.INVALID_INPUT);
		}
		validateIfChannelAlreadySubscribed(customer,selectedChannels);
		validateIfFundsAvailable(customer,selectedChannels);
		selectedChannels.stream().forEach((channel) -> {
			customer.getSubscription().getAdditionalChannelList().add(channel);
			customer.setAccountBalance(customer.getAccountBalance()-channel.getAmount());
		});
		customerService.updateCustomer(customer);
		return new AddChannelOutput(customer.getAccountBalance());
	}
	
	private void validateIfFundsAvailable(Customer customer, List<Channel> selectedChannels) {
		double totalAmount = selectedChannels.stream().mapToDouble((channel) -> channel.getAmount()).sum();
		if(totalAmount>customer.getAccountBalance()) {
			throw new CustomException(Configuration.INSUFFICIENT_FUNDS);
		}
		
	}
	private void validateIfChannelAlreadySubscribed(Customer customer, List<Channel> selectedChannels) {
		customer.getSubscription().getAdditionalChannelList().stream().forEach((subscribedChannel) ->{
			boolean doesChannelExist = selectedChannels.stream().anyMatch((selectedChannel) -> {
				return selectedChannel.getName().equalsIgnoreCase(subscribedChannel.getName());
			});
			if(doesChannelExist) {
				throw new CustomException(Configuration.CHANNEL_ALREADY_SUBSCRIBED);
			}
		});
		
	}
	private List<Channel> getChannelListFromChannelName(String[] channelNames) {
		List<Channel> allChannels = DatabaseInstance.getInstance().getChannelList();
		List<Channel> selectedChannels = allChannels.stream().filter((channel) -> {
			return Arrays.stream(channelNames).anyMatch((name)->{
				return name.equalsIgnoreCase(channel.getName());
			});
		}).collect(Collectors.toList());
		return selectedChannels;
	}
	
	private void validateIfBasePackSubscribed(Customer customer) {
		
		if(customer.getSubscription()== null || customer.getSubscription().getBasePack()==null) {
			throw new CustomException(Configuration.NO_BASE_PACK);
		}

	}
}
