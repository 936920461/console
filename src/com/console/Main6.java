package com.console;

import java.io.PrintStream;
import java.util.Scanner;

public class Main6 {

	private String greet = "hello";
	private static String greet1 = "hello";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 10;
		int b = 10;
		method(a,b);
		Scanner sc = new Scanner(System.in);
		String string = sc.nextLine();
		System.out.println(string);
	}

	public static void method(int a, int b) {
		final int a1 = 100;
		System.setOut(new PrintStream(System.out,true){
			@Override
			public void println(){
				super.println(a1);
			}
		});
	}
	private void  test() {
		String aString= this.greet1;
	}
}
