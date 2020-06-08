package com.techverito.sattv.service;

import java.util.List;

import com.techverito.sattv.database.DatabaseInstance;
import com.techverito.sattv.domain.BasePack;

public class BasePackService {
	
	public BasePack fetchBasePack(String basePackName) {
		List<BasePack> basePackList = DatabaseInstance.getInstance().getBasePackList();
		BasePack basePack = basePackList.stream().filter(
				(base)-> {
					return base.getName().equalsIgnoreCase(basePackName);
					}
				).findFirst().get();
		return basePack;
	}

}
