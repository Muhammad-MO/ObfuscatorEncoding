package com.simpleloginform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.simpleloginform"})

public class SimpleloginformApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleloginformApplication.class, args);
	}

}
