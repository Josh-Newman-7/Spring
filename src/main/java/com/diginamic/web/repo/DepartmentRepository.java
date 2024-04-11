package com.diginamic.web.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.diginamic.web.models.Department;

public interface DepartmentRepository extends CrudRepository<Department, Integer>{

	List<Department> findByCode(String code);
}
