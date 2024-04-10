package com.diginamic.web.controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.diginamic.web.models.Town;
import com.diginamic.web.repo.TownRepository;

@RestController
@RequestMapping("/towns")
public class TownController {
	
	@Autowired
	TownRepository townRepository;
	
	@GetMapping
	 public List<Town> getTowns(){
		return (List<Town>) this.townRepository.findAll();
	 };
	 
	 @GetMapping("/{id}")
	 public Town getTownById(@PathVariable int id){
		 return this.townRepository.findById(id).get();
	 };
	 
	 @GetMapping("/name/{name}")
	 public Town getTownByName(@PathVariable String name){
		 return this.townRepository.findByNameStartsWith(name).get(0);
	 };
	 
	 @PostMapping
	 public ResponseEntity<String> postTown(@RequestBody Town town) {
		 this.townRepository.save(town);
		 return new ResponseEntity<String>("Ville insérée avec succès", HttpStatus.OK);
	 }
	 
	 @PutMapping
	 public ResponseEntity<String> putTown(@RequestBody Town town) {
		 this.townRepository.save(town);
		 return ResponseEntity.ok("Ville modifiée avec succès");
    }
	 
	 @DeleteMapping("/{id}")
	 public ResponseEntity<String> deleteTown(@PathVariable int id) {
		 this.townRepository.deleteById(id);
         return ResponseEntity.ok("Ville suprimée avec succès");
    }
}
