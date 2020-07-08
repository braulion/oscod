package com.oscod.microservices.app.examenes.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.oscod.microservices.app.examenes.models.entity.Examen;
import com.oscod.microservices.app.examenes.services.ExamenService;
import com.oscod.microservices.commons.controllers.CommonController;

@RestController
public class ExamenController  extends CommonController<Examen, ExamenService>{
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Examen examen, @PathVariable Long id) {
		return null;
	}

}
