package com.diginamic.web.controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.diginamic.web.models.Town;
import com.diginamic.web.services.TownService;

@RestController
@RequestMapping("/towns")
public class TownController {
	
	@Autowired
	TownService townService;
	
	@GetMapping
	 public List<Town> getTowns(){
		return this.townService.getTowns();
	 };
	 
	 @GetMapping("/{id}")
	 public Town getTownById(@PathVariable int id){
		 return this.townService.getTownById(id);
	 };
	 
	 @GetMapping("/name/{name}")
	 public Town getTownByName(@PathVariable String name){
		 return this.townService.getTownByName(name);
	 };
	 
	 @PostMapping
	 public ResponseEntity<String> postTown(@RequestBody Town town) {
		 this.townService.addTown(town);
		 return new ResponseEntity<String>("Ville insérée avec succès", HttpStatus.OK);
	 }
	 
	 @PutMapping
	 public ResponseEntity<String> putTown(@RequestBody Town town) {
		 this.townService.updateTown(town);
		 return ResponseEntity.ok("Ville modifiée avec succès");
    }
	 
	 @DeleteMapping("/{id}")
	 public ResponseEntity<String> deleteTown(@PathVariable int id) {
		 this.townService.deleteTown(id);
         return ResponseEntity.ok("Ville suprimée avec succès");
    }
}
