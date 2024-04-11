package com.diginamic.web.repo;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.diginamic.web.models.Town;


public interface TownRepository extends CrudRepository<Town, Integer> {

    List<Town> findByNameStartsWith(String name);

    List<Town> findByPopulationGreaterThan(int min);

    List<Town> findByPopulationBetween(int min, int max);

    List<Town> findByDepartmentAndPopulationGreaterThan(String codeDep, int nbHab);

    List<Town> findByDepartmentAndPopulationBetween(String codeDep, int nbHabMin, int nbHabMax);

    List<Town> findTopNTownsByDepartement(String codeDep, Pageable pageable);

}
