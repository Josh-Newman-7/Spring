package com.diginamic.web.controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.diginamic.web.dto.TownDTO;
import com.diginamic.web.mappers.TownMapper;
import com.diginamic.web.models.Town;
import com.diginamic.web.services.TownService;

@RestController
@RequestMapping("/towns")
public class TownController {
	
	@Autowired
	TownService townService;
	
	@GetMapping
	 public List<TownDTO> getTowns(){
		List<Town> existingTowns = townService.getTowns();
		List<TownDTO> townsToReturn = new ArrayList<TownDTO>();
		for(Town t : existingTowns) {
			townsToReturn.add(TownMapper.toDto(t));
		}
		return townsToReturn;
	 };
	 
	 @GetMapping("/{id}")
	 public TownDTO getTownById(@PathVariable int id){
		 return TownMapper.toDto(townService.getTownById(id));
	 };
	 
	 @GetMapping("/name/{name}")
	 public TownDTO getTownByName(@PathVariable String name){
		 return TownMapper.toDto(townService.getTownByName(name));
	 };
	 
	 @PostMapping
	 public ResponseEntity<String> postTown(@RequestBody TownDTO town) {
		 if(townService.addTown(TownMapper.toBean(town))) {
			 return new ResponseEntity<String>("Ville insérée avec succès", HttpStatus.OK);
		 }
		 return new ResponseEntity<String>("Erreur lors de l'insertion d'une nouvelle ville", HttpStatus.BAD_REQUEST);
	 }
	 
	 @PutMapping
	 public ResponseEntity<String> putTown(@RequestBody TownDTO town) {
		 if(townService.updateTown(TownMapper.toBean(town))) {
			 return new ResponseEntity<String>("Ville modifiée avec succès", HttpStatus.OK);
		 }
		 return new ResponseEntity<String>("Erreur lors de la modification d'une ville", HttpStatus.BAD_REQUEST);
    }
	 
	 @DeleteMapping("/{id}")
	 public ResponseEntity<String> deleteTown(@PathVariable int id) {
		 if(townService.deleteTown(id)) {
			 return new ResponseEntity<String>("Ville supprimée avec succès", HttpStatus.OK);
		 }
		 return new ResponseEntity<String>("Erreur lors de la suppression d'une ville", HttpStatus.BAD_REQUEST);
    }
}
