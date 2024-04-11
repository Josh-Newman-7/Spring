package com.diginamic.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diginamic.web.models.Department;
import com.diginamic.web.repo.DepartmentRepository;

@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository departementRepository;
	
    public List<Department> getDepartments() {
        return (List<Department>) departementRepository.findAll();
    }

    public Department getDepartmentById(int id) {
    	return departementRepository.findById(id).get() != null ? departementRepository.findById(id).get() : null;
    }
    
    public Department getDepartmentByCode(String code) {
    	return departementRepository.findByCode(code).get(0) != null ? departementRepository.findByCode(code).get(0) : null;
    }

    public boolean addDepartment(Department department) {
        Department d = departementRepository.findById(department.getId()).get();
        if(d != null) {
        	return false;
        }
        departementRepository.save(department);
        return true;
    }

    public boolean updateDepartment(Department updatedDepartment) {
    	Department dDB = departementRepository.findById(updatedDepartment.getId()).get();
        if(dDB == null) {
        	return false;
        }
        dDB.setName(updatedDepartment.getName());
        dDB.setCode(updatedDepartment.getCode());
        dDB.setTowns(updatedDepartment.getTowns());
        departementRepository.save(updatedDepartment);
        return true;
    }

    public boolean deleteDepartment(int id) {
        Department d = departementRepository.findById(id).get();
        if(d == null) {
        	return false;
        }
        departementRepository.deleteById(id);
        return true;
    }
}
