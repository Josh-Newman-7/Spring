package com.diginamic.DigiHello1;

import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloService {

	public String salutations() {
		return new String("Je suis la classe de service et je vous dis Bonjour");
	}
}
