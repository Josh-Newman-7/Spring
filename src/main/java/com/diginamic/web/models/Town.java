package com.diginamic.web.models;

import java.util.Objects;

public class Town {
	private String name;
	private int nbHab;
	private int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Town(String name, int nbHab, int id) {
		super();
		this.name = name;
		this.nbHab = nbHab;
		this.id = id;
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
}
