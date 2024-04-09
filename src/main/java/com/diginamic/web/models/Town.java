package com.diginamic.web.models;

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
	
}
