package com.diginamic.web.controllers;

import java.util.*;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.diginamic.web.models.Town;

@RestController
@RequestMapping("/towns")
public class TownController {
	
	private Set<Town> towns = new HashSet<>();

    public TownController() {
        towns.add(new Town("Nice", 343000));
        towns.add(new Town("Carcassonne", 47800));
        towns.add(new Town("Narbonne", 53400));
        towns.add(new Town("Lyon", 484000));
        towns.add(new Town("Foix", 9700));
        towns.add(new Town("Pau", 77200));
        towns.add(new Town("Marseille", 850700));
        towns.add(new Town("Tarbes", 40600));
    }
	
	@GetMapping
	 public Set<Town> getTowns(){
		return towns;
	 };
	 
	 @PostMapping
	 public ResponseEntity<String> postTown(@RequestBody Town town) {
		 if(towns.contains(town)) {
			 return new ResponseEntity<String>("La ville existe déjà", HttpStatus.BAD_REQUEST);
		 }
		 towns.add(town);
		 return new ResponseEntity<String>("Ville insérée avec succès", HttpStatus.OK);
	 }
}
