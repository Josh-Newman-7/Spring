package com.diginamic.web.models;

import java.util.Objects;

public class Town {
	private String name;
	private int nbHab;
	
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

	public Town(String name, int nbHab) {
		super();
		this.name = name;
		this.nbHab = nbHab;
	}
	
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Town town = (Town) o;
        return nbHab == town.nbHab && Objects.equals(name, town.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, nbHab);
    }
}
