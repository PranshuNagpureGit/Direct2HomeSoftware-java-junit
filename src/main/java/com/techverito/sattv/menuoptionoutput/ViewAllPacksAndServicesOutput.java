package com.techverito.sattv.menuoptionoutput;

import java.util.List;

import com.techverito.sattv.domain.BasePack;
import com.techverito.sattv.domain.AdditionalService;
import com.techverito.sattv.domain.Channel;

public class ViewAllPacksAndServicesOutput implements IMenuOptionOutput {
	private List<BasePack> basePackList;
	private List<Channel> channelList;
	private List<AdditionalService> additionalServices;

	public ViewAllPacksAndServicesOutput(List<BasePack> basePackList,List<Channel> channelList,List<AdditionalService> additionalServices) {
		this.channelList = channelList;
		this.basePackList = basePackList;
		this.additionalServices = additionalServices;
	}
	
	public List<BasePack> getBasePackList() {
		return basePackList;
	}
	public List<Channel> getChannelList() {
		return channelList;
	}
	public List<AdditionalService> getAdditionalServices() {
		return additionalServices;
	}

}
