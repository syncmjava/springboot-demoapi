package com.example.demo.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class SpringbootDemoapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDemoapiApplication.class, args);
	}

}
