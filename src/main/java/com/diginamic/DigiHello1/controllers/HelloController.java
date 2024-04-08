package com.diginamic.DigiHello1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diginamic.DigiHello1.HelloService;

@RestController
@RequestMapping("/hello")
public class HelloController {
	
	@Autowired
	private HelloService helloservice;
	
	@GetMapping
	 public String direHello(){
		return helloservice.salutations();
	 }
}
