package com.diginamic.web.mappers;

import org.springframework.stereotype.Component;

import com.diginamic.web.dto.TownDTO;
import com.diginamic.web.models.Department;
import com.diginamic.web.models.Town;
import com.diginamic.web.services.DepartmentService;
import com.diginamic.web.services.TownService;

@Component
public class TownMapper {
	
	public static TownDTO toDto(Town town) {
        TownDTO dto = new TownDTO();
        dto.setName(town.getName());
        dto.setTownCode(town.getCodeDep());
        dto.setPopulation(town.getNbHab());
        dto.setDepartmentCode(town.getDepartment().getCode());
        dto.setDepartmentName(town.getDepartment().getName());
        return dto;
    }

    public static Town toBean(TownDTO dto) {
        Town town = new Town();
        town.setName(dto.getName());
        town.setNbHab(dto.getPopulation());
        
        Department department = new Department();
        department.setCode(dto.getDepartmentCode());
        department.setName(dto.getDepartmentName());
        town.setDepartment(department);
        
        Town t = new TownService().getTownById(town.getId());
        if(t != null) {
        	town.setId(town.getId());
        }
        Department d = new DepartmentService().getDepartmentByCode(dto.getDepartmentCode());
        if (d != null) {
        	d.setName(department.getName());
        	town.setDepartment(d);
        }
        return town;
    }
}
