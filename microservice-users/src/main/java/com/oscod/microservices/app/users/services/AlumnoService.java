package com.oscod.microservices.app.users.services;

import java.util.List;

import com.oscod.microservices.commons.alumnos.models.entity.Alumno;
import com.oscod.microservices.commons.services.CommonService;

public interface AlumnoService extends CommonService<Alumno>{

	public List<Alumno> findByNombreOrApellido(String term);

	
	
}
