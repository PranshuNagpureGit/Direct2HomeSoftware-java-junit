package com.techverito.sattv.utils;

public final class ApplicationUtil {
	
	private ApplicationUtil() {
		
	}
	public static void printMessage(String message) {
		System.out.println(message);
	}
	public static void printEmptyLines(int number) {
		for(int i=0;i<number;i++) {
			System.out.println("");
		}
	}
	
	
}
