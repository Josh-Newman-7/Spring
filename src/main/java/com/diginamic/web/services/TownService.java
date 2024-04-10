package com.diginamic.web.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.diginamic.web.models.Town;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;

@Service
public class TownService {
    
	@PersistenceContext
	private EntityManager em;

    public List<Town> getTowns() {
        return em.createQuery("SELECT t FROM Town t", Town.class).getResultList();
    }

    public Town getTownById(int id) {
        return em.find(Town.class, id);
    }

    public Town getTownByName(String name) {
        return em.createQuery("SELECT t FROM Town t WHERE t.name = :name", Town.class)
                .setParameter("name", name)
                .getSingleResult();
    }

    @Transactional
    public List<Town> addTown(Town town) {
        em.persist(town);
        return getTowns();
    }

    @Transactional
    public List<Town> updateTown(Town updatedTown) {
    	em.merge(updatedTown);
        return getTowns();
    }

    @Transactional
    public List<Town> deleteTown(int id) {
        Town town = em.find(Town.class, id);
        if (town != null) {
            em.remove(town);
        }
        return getTowns();
    }
    
}

