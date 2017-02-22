package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.business.Dog;

@Configuration
public class ConfigureXML {

	@Bean(name = "dog")
	public Dog getDog() {
		return new Dog();
	}
}
