package com.diginamic.web.controllers;

import java.util.*;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.diginamic.web.models.Town;

@RestController
@RequestMapping("/towns")
public class TownController {
	
	private ArrayList<Town> towns = new ArrayList<>();

    public TownController() {
        towns.add(new Town("Nice", 343000, 1));
        towns.add(new Town("Carcassonne", 47800, 2));
        towns.add(new Town("Narbonne", 53400, 3));
        towns.add(new Town("Lyon", 484000, 4));
        towns.add(new Town("Foix", 9700, 5));
        towns.add(new Town("Pau", 77200, 6));
        towns.add(new Town("Marseille", 850700, 7));
        towns.add(new Town("Tarbes", 40600, 8));
    }
	
	@GetMapping
	 public List<Town> getTowns(){
		return this.towns;
	 };
	 
	 @GetMapping
	 public List<Town> getTownById(@RequestBody int id){
		List<Town> result = new ArrayList<>();
        for (Town town : this.towns) {
            if (town.getId() == id) {
                result.add(town);
            }
        }
        return result;
	 };
	 
	 @PostMapping
	 public ResponseEntity<String> postTown(@RequestBody Town town) {
		 List<Town> towns = new ArrayList<>();
        for (Town t : towns) {
            if (t.getId() == town.getId()) {
            	return new ResponseEntity<String>("La ville existe déjà", HttpStatus.BAD_REQUEST);
            }
        }
		 this.towns.add(town);
		 return new ResponseEntity<String>("Ville insérée avec succès", HttpStatus.OK);
	 }
	 
	 @PutMapping
	 public ResponseEntity<String> putTown(@RequestBody Town town) {
        for (Town existingTown : this.towns) {
            if (existingTown.getId() == town.getId()) {
                existingTown.setName(town.getName());
                existingTown.setNbHab(town.getNbHab());
                return ResponseEntity.ok("Ville mise à jour avec succès");
            }
        }
        return ResponseEntity.notFound().build();
    }
	 
	 @DeleteMapping
	 public ResponseEntity<String> deleteTown(@RequestBody int id) {
        for (Town existingTown : this.towns) {
            if (existingTown.getId() == id) {
                this.towns.remove(existingTown);
                return ResponseEntity.ok("Ville suprimée avec succès");
            }
        }
        return ResponseEntity.notFound().build();
    }
}
