package com.oscod.microservices.app.examenes.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.oscod.microservices.app.examenes.services.ExamenService;
import com.oscod.microservices.commons.controllers.CommonController;
import com.oscod.microservices.commons.examenes.models.entity.Examen;
import com.oscod.microservices.commons.examenes.models.entity.Pregunta;

@RestController
public class ExamenController  extends CommonController<Examen, ExamenService>{
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Examen examen, @PathVariable Long id) {
		Optional<Examen> o = service.findById(id);
		
		if (!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Examen examenToUpdate = o.get();
		examenToUpdate.setNombre(examen.getNombre());
		List<Pregunta> preguntasEliminadas = new ArrayList<>();
		examenToUpdate.getPreguntas().forEach(pregunta -> {
			if (!examen.getPreguntas().contains(pregunta)) {
				preguntasEliminadas.add(pregunta);
			}
		});
		examenToUpdate.getPreguntas().stream().filter(preg -> !examen.getPreguntas().contains(preg))
				.forEach(examenToUpdate::removePregunta);
		examenToUpdate.setPreguntas(examen.getPreguntas());
		return ResponseEntity.ok().body(service.save(examenToUpdate));
	}
	
	@GetMapping("/filtrar/{value}")
	public ResponseEntity<?> filtrar(@PathVariable String value) {
		if (value == null || value.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok().body(service.findByNombre(value));
	}
	
	
	

}
