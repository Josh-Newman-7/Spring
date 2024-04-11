package com.diginamic.web.mappers;

import org.springframework.stereotype.Component;

import com.diginamic.web.dto.DepartmentDTO;
import com.diginamic.web.models.Department;
import com.diginamic.web.models.Town;

@Component
public class DepartmentMapper {

    public static DepartmentDTO toDto(Department department) {
        DepartmentDTO dto = new DepartmentDTO();
        dto.setDepartmentCode(department.getCode());
        dto.setDepartmentName(department.getName());
        for(Town t : department.getTowns()) {
        	dto.setPopulation(dto.getPopulation()+t.getNbHab());
        }
        return dto;
    }

    public static Department toBean(DepartmentDTO dto) {
        Department department = new Department();
        department.setCode(dto.getDepartmentCode());
        department.setName(dto.getDepartmentName());
        return department;
    }
}