package com.diginamic.web.controllers;

import java.io.IOException;
import java.util.*;
import java.util.List;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.diginamic.web.dto.TownDTO;
import com.diginamic.web.exceptions.CustomException;
import com.diginamic.web.mappers.TownMapper;
import com.diginamic.web.models.Town;
import com.diginamic.web.services.TownService;

import jakarta.servlet.http.HttpServletResponse;

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
	 
	 @GetMapping("/{name}/fiche")
    public void exportTownCSV(@PathVariable String name, HttpServletResponse response) throws IOException, DocumentException {
        Town town = townService.getTownByName(name);
        if (town == null) {
            response.setStatus(HttpStatus.NOT_FOUND.value());
            response.getWriter().write("Ville non trouvée.");
            return;
        }

        response.setHeader("Content-Disposition", "attachment; filename=\"" + town.getName() + ".pdf\"");
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
        document.open();
        document.add(new Paragraph("Nom de la ville : " + town.getName()));
        document.add(new Paragraph("Nombre d'habitants : " + town.getNbHab()));
        document.add(new Paragraph("Code département : " + town.getDepartment().getCode()));
        document.add(new Paragraph("Nom du département : " + town.getDepartment().getName()));
        document.close();
    }
	 
	 @PostMapping
	 public ResponseEntity<String> postTown(@RequestBody TownDTO town) {
		 try {
			 if(townService.addTown(TownMapper.toBean(town))) {
				 return new ResponseEntity<String>("Ville insérée avec succès", HttpStatus.OK);
			 }
		 } catch (CustomException e) {
			 e.printStackTrace();
		 }
		 return new ResponseEntity<String>("Erreur lors de l'insertion d'une nouvelle ville", HttpStatus.BAD_REQUEST);
	 }
	 
	 @PutMapping
	 public ResponseEntity<String> putTown(@RequestBody TownDTO town) {
		 try {
			if(townService.updateTown(TownMapper.toBean(town))) {
				 return new ResponseEntity<String>("Ville modifiée avec succès", HttpStatus.OK);
			 }
		} catch (CustomException e) {
			e.printStackTrace();
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
