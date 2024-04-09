package com.diginamic.web.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diginamic.web.models.Town;

@RestController
@RequestMapping("/towns")
public class TownController {
	
	@GetMapping
	 public List<Town> getTowns(){
		return new ArrayList<>(Arrays.asList(
				new Town("Nice", 343000),
				new Town("Carcassonne", 47800),
				new Town("Narbonne", 53400),
				new Town("Lyon", 484000),
				new Town("Foix", 9700),
				new Town("Pau", 77200),
				new Town("Marseille", 850700),
				new Town("Tarbes", 40600)
				));
	 };
}
