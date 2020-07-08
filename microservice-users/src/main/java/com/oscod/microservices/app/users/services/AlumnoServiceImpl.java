package com.oscod.microservices.app.users.services;

import java.util.List;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oscod.microservices.app.users.models.repository.AlumnoRepository;
import com.oscod.microservices.commons.alumnos.models.entity.Alumno;
import com.oscod.microservices.commons.services.CommonServiceImpl;

@Service
public class AlumnoServiceImpl extends CommonServiceImpl<Alumno, AlumnoRepository> implements AlumnoService {

	@Override
	@Transactional(readOnly = true)
	public List<Alumno> findByNombreOrApellido(String term) {
		return repository.findByNombreOrApellido(term);
	}

	

}
