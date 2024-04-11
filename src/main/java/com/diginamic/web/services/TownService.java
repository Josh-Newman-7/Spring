package com.diginamic.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diginamic.web.models.Town;
import com.diginamic.web.repo.TownRepository;

@Service
public class TownService {
    
    @Autowired
    private TownRepository townRepository;

    public List<Town> getTowns() {
        return (List<Town>) townRepository.findAll();
    }

    public Town getTownById(int id) {
    	return townRepository.findById(id).get() != null ? townRepository.findById(id).get() : null;
    }

    public Town getTownByName(String name) {
        return townRepository.findByNameStartsWith(name).get(0) != null ? townRepository.findByNameStartsWith(name).get(0) : null;
    }

    public boolean addTown(Town town) {
        Town t = townRepository.findByNameStartsWith(town.getName()).get(0);
        if(t != null) {
        	return false;
        }
        townRepository.save(town);
        return true;
    }

    public boolean updateTown(Town updatedTown) {
    	Town tDB = townRepository.findById(updatedTown.getId()).get();
        if(tDB == null) {
        	return false;
        }
        tDB.setName(updatedTown.getName());
        tDB.setNbHab(updatedTown.getNbHab());
        townRepository.save(updatedTown);
        return true;
    }

    public boolean deleteTown(int id) {
        Town t = townRepository.findById(id).get();
        if(t == null) {
        	return false;
        }
        townRepository.deleteById(id);
        return true;
    }
}
