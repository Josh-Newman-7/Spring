package com.diginamic.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.diginamic.web.dto.DepartmentDTO;
import com.diginamic.web.exceptions.CustomException;
import com.diginamic.web.mappers.DepartmentMapper;
import com.diginamic.web.models.*;
import com.diginamic.web.services.DepartmentService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @GetMapping
    public List<DepartmentDTO> getAllDepartments() {
		List<Department> existingDepartment = departmentService.getDepartments();
		List<DepartmentDTO> departmentsToReturn = new ArrayList<DepartmentDTO>();
		for(Department d : existingDepartment) {
			departmentsToReturn.add(DepartmentMapper.toDto(d));
		}
		return departmentsToReturn;
    }

    @GetMapping("/{id}")
    public DepartmentDTO getDepartmentById(@PathVariable int id) {
    	return DepartmentMapper.toDto(departmentService.getDepartmentById(id));
    }

    @PostMapping
    public ResponseEntity<String> addDepartment(@RequestBody DepartmentDTO department) {
    	try {
			if(departmentService.addDepartment(DepartmentMapper.toBean(department))) {
				 return new ResponseEntity<String>("Départment inséré avec succès", HttpStatus.OK);
			 }
		} catch (CustomException e) {
			e.printStackTrace();
		}
		 return new ResponseEntity<String>("Erreur lors de l'insertion d'un nouveau département", HttpStatus.BAD_REQUEST);
    }

    @PutMapping
    public ResponseEntity<String> updateDepartment(@RequestBody DepartmentDTO updatedDepartment) {
    	try {
			if(departmentService.updateDepartment(DepartmentMapper.toBean(updatedDepartment))) {
				 return new ResponseEntity<String>("Départment modifié avec succès", HttpStatus.OK);
			 }
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return new ResponseEntity<String>("Erreur lors de la modification d'un département", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable int id) {
    	if(departmentService.deleteDepartment(id)) {
			 return new ResponseEntity<String>("Département supprimé avec succès", HttpStatus.OK);
		 }
		 return new ResponseEntity<String>("Erreur lors de la suppression d'un département", HttpStatus.BAD_REQUEST);
    }
}
