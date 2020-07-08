package com.oscod.microservices.app.examenes.services;

import org.springframework.stereotype.Service;

import com.oscod.microservices.app.examenes.models.entity.Examen;
import com.oscod.microservices.app.examenes.models.entity.repository.ExamanesRepository;
import com.oscod.microservices.commons.services.CommonServiceImpl;

@Service
public class ExamenServiceImpl extends CommonServiceImpl<Examen, ExamanesRepository> implements ExamenService{

}
