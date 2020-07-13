package com.oscod.microservices.app.examenes.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oscod.microservices.app.examenes.models.entity.repository.ExamanesRepository;
import com.oscod.microservices.commons.examenes.models.entity.Examen;
import com.oscod.microservices.commons.services.CommonServiceImpl;

@Service
public class ExamenServiceImpl extends CommonServiceImpl<Examen, ExamanesRepository> implements ExamenService{

	@Override
	@Transactional(readOnly = true)
	public List<Examen> findByNombre(String value) {
		return repository.findByNombre(value);
	}

}
