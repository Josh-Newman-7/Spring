package com.diginamic.web.models;

import jakarta.persistence.*;

import java.util.*;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String code;
    private String name;

    @OneToMany(mappedBy = "department")
    private List<Town> towns = new ArrayList<Town>();
    
	public Department(String code, String name, List<Town> towns) {
		super();
		this.code = code;
		this.name = name;
		this.towns = towns;
	}
	
	public Department(String code, String name) {
		super();
		this.code = code;
		this.name = name;
	}

	public Department() {}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public List<Town> getTowns() {
		return towns;
	}
	public void setTowns(List<Town> towns) {
		this.towns = towns;
	}


}