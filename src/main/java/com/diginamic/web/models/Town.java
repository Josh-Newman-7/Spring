package com.diginamic.web.models;

import java.util.Objects;


import jakarta.persistence.*;

@Entity
public class Town {
	private String name;
	private int nbHab;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int id;
	private String codeDep;
	
	@ManyToOne
    private Department department;
	
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Town () {
		
	}
	public Town(String name, int nbHab, String codeDep) {
		super();
		this.name = name;
		this.nbHab = nbHab;
		this.codeDep = codeDep;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getNbHab() {
		return nbHab;
	}
	public void setNbHab(int nbHab) {
		this.nbHab = nbHab;
	}

	
    
	@Override
    public boolean equals(Object o) {
        if (this == o) 
        	return true;
        if (o == null || getClass() != o.getClass()) 
        	return false;
        
        Town town = (Town) o;
        return this.id == town.id;
    }

    
	@Override
    public int hashCode() {
        return Objects.hash(id);
    }

	public String getCodeDep() {
		return codeDep;
	}

	public void setCodeDep(String codeDep) {
		this.codeDep = codeDep;
	}


}
