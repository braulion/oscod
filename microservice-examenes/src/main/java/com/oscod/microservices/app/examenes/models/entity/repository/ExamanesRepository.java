package com.oscod.microservices.app.examenes.models.entity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.oscod.microservices.commons.examenes.models.entity.Examen;

public interface ExamanesRepository extends PagingAndSortingRepository<Examen, Long>{
	
	@Query("select e from Examen e where e.nombre like %?1%")
	public List<Examen> findByNombre(String value);

}
