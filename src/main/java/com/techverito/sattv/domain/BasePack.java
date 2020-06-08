package com.techverito.sattv.domain;

import java.util.List;

public class BasePack {
	private String name;
	private double amount;
	private List<Channel> channelList;
	
	public BasePack(String name, double amount, List<Channel> channelList) {
		this.name = name;
		this.amount = amount;
		this.channelList = channelList;
	}
	
	public String getName() {
		return name;
	}

	public double getAmount() {
		return amount;
	}
	public List<Channel> getChannelList() {
		return channelList;
	}

}
