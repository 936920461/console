package com.console;

public class SingleInstence {
	
	
	public SingleInstence() {
		
	}

	private static SingleInstence singleInstence = null;

	public static SingleInstence getInstence() {
		if (singleInstence == null) {
			singleInstence = new SingleInstence();
		}
		return singleInstence;
	}
}
