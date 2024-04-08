package com.diginamic.DigiHello1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.diginamic.DigiHello1.Configurator.Config;

@SpringBootApplication
public class DigiHello1Application {

	@Autowired
	Config config;
	
	public static void main(String[] args) {
		SpringApplication.run(DigiHello1Application.class, args);
	}

}
