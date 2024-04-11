package com.diginamic.web.dto;

public class DepartmentDTO {
    private String departmentCode;
    private String departmentName;
    private int population;
    
	public DepartmentDTO(String departmentCode, String departmentName, int population) {
		super();
		this.departmentCode = departmentCode;
		this.departmentName = departmentName;
		this.population = population;
	}

	
	public DepartmentDTO() {}


	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

}
