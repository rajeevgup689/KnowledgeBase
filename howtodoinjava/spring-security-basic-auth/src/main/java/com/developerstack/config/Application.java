package com.developerstack.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.developerstack")
@SpringBootApplication
public class Application extends SpringBootServletInitializer {

	private static Class appClass = Application.class;

	public static void main(String[] args) {
		SpringApplication.run(appClass, args);
	}

}