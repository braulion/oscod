package com.oscod.microservices.app.examenes.services;

import java.util.List;

import com.oscod.microservices.commons.examenes.models.entity.Examen;
import com.oscod.microservices.commons.services.CommonService;

public interface ExamenService extends CommonService<Examen> {
	
	public List<Examen> findByNombre(String value);


}
