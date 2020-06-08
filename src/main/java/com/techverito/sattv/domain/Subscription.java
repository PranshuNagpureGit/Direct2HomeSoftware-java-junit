package com.techverito.sattv.domain;

import java.util.ArrayList;
import java.util.List;

public class Subscription {

	private BasePack basePack;
	private List<Channel> additionalChannelList;
	private List<AdditionalService> additionalServiceList;
	private int durationInMonths;
	
	public Subscription() {
		additionalChannelList = new ArrayList<Channel>();
		additionalServiceList=new ArrayList<AdditionalService>();
	}
	
	public List<Channel> getAdditionalChannelList() {
		return additionalChannelList;
	}
	public List<AdditionalService> getAdditionalServiceList() {
		return additionalServiceList;
	}
	public int getDurationInMonths() {
		return durationInMonths;
	}
	public BasePack getBasePack() {
		return basePack;
	}
	public void setBasePack(BasePack basePack) {
		this.basePack = basePack;
	}
	public void setDurationInMonths(int durationInMonths) {
		this.durationInMonths = durationInMonths;
	}

	
}
