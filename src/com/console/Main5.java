package com.console;

public class Main5 {

	public static void main(String[] args) {

		System.out.println("start");
		loop: 
			for (int i = 0; i < 5; i++) {
			System.out.println("i:"+ i);
				for (int j = 0; j < 5; j++) {
					System.out.println("j:"+ j);
					if (i == 2) {
						break loop;
					}
			}
		}
		System.out.println("end");
	}

}
