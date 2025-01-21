package com.scierie_application.scierie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class ScierieApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScierieApplication.class, args);
	}


	public  static String generateUUID() {
		return UUID.randomUUID().toString();
	}

}
