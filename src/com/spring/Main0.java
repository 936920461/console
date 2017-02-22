package com.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.business.Dog;

public class Main0 {

	public static void main(String[] args) {
		// ApplicationContext cxt = new
		// AnnotationConfigApplicationContext(ConfigureXML.class);
		ApplicationContext cxt = new AnnotationConfigApplicationContext("com.config");
		Dog dog = cxt.getBean("dog", Dog.class);
		dog.syaHi();
	}

}
