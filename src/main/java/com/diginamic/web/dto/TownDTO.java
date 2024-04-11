package com.diginamic.web.dto;

public class TownDTO {
    private String townCode;
    private String name;
    private int population;
    private String departmentCode;
    private String departmentName;
    
	public TownDTO(String name, String townCode, int population, String departmentCode, String departmentName) {
		super();
		this.name = name;
		this.townCode = townCode;
		this.population = population;
		this.departmentCode = departmentCode;
		this.departmentName = departmentName;
	}

	
	public TownDTO() {}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTownCode() {
		return townCode;
	}

	public void setTownCode(String townCode) {
		this.townCode = townCode;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

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


}