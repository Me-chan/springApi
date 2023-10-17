package com.example.springApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class SpringApiApplication {

	
	/** 
	 * @param args
	 * Main function
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringApiApplication.class, args);
	}

}
