package com.techverito.sattv.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.techverito.sattv.domain.AdditionalService;
import com.techverito.sattv.domain.BasePack;
import com.techverito.sattv.domain.Channel;
import com.techverito.sattv.domain.Customer;

public class DatabaseInstance{
	
	private static DatabaseInstance instance;
	
	private final HashMap<Long,Customer> customerRecordMap;
	private final List<Channel> channelList;
	private final List<BasePack> basePackList;
	private final List<AdditionalService> additionalServices;
	
	 
	
	private DatabaseInstance() {
		customerRecordMap = new HashMap<Long,Customer>();
		customerRecordMap.put(1L, new Customer(1L, "abc"));
		customerRecordMap.put(2L, new Customer(2L, "def"));
		
		channelList = new ArrayList<Channel>();
		channelList.add(new Channel("Zee", 10));
		channelList.add(new Channel("Sony", 15));
		channelList.add(new Channel("Star Plus",20));
		channelList.add(new Channel("Discovery",10));
		channelList.add(new Channel("NatGeo",20));
		
		basePackList = new ArrayList<BasePack>();
		
		List<Channel> goldPackList = new ArrayList<Channel>();
		goldPackList.add(channelList.get(0));
		goldPackList.add(channelList.get(1));
		goldPackList.add(channelList.get(2));
		goldPackList.add(channelList.get(3));
		goldPackList.add(channelList.get(4));
		
		List<Channel> silverPackList = new ArrayList<Channel>();
		silverPackList.add(channelList.get(0));
		silverPackList.add(channelList.get(1));
		silverPackList.add(channelList.get(2));
		
		basePackList.add(new BasePack("Gold", 100, goldPackList));
		basePackList.add(new BasePack("Silver", 50, silverPackList));
		
		additionalServices = new ArrayList<AdditionalService>();
		additionalServices.add(new AdditionalService("LearnEnglish", 200));
		additionalServices.add(new AdditionalService("LearnCooking", 100));
	}
	public static DatabaseInstance getInstance() {
		if(instance==null) {
			instance = new DatabaseInstance();
		}
		return instance;
	}
	
	public HashMap<Long, Customer> getCustomerRecords() {
		return customerRecordMap;
	}
	public List<Channel> getChannelList() {
		return channelList;
	}
	public List<BasePack> getBasePackList() {
		return basePackList;
	}
	public List<AdditionalService> getAdditionalServices() {
		return additionalServices;
	}

	

}