package com.diginamic.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class SpringExercice3Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringExercice3Application.class, args);
	}

}
