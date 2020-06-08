package com.techverito.sattv.menuoptioninput;

import com.techverito.sattv.domain.BasePack;

public class SubscribeBasePackInput implements IMenuOptionInput {
	
	private String selectedBasePack;
	private String durationInMonths;
	
	private BasePack concreteBasePack;
	
	public SubscribeBasePackInput(String selectedBasePack, String durationInMonths) {
		this.selectedBasePack = selectedBasePack;
		this.durationInMonths = durationInMonths;
	}
	public String getSelectedBasePack() {
		return selectedBasePack;
	}
	public String getDurationInMonths() {
		return durationInMonths;
	}
	public BasePack getConcreteBasePack() {
		return concreteBasePack;
	}
	public void setConcreteBasePack(BasePack concreteBasePack) {
		this.concreteBasePack = concreteBasePack;
	}

	
}
