package com.oscod.microservices.app.users.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.oscod.microservices.app.users.services.AlumnoService;
import com.oscod.microservices.commons.alumnos.models.entity.Alumno;
import com.oscod.microservices.commons.controllers.CommonController;

@RestController
public class AlumnoController extends CommonController<Alumno, AlumnoService>{

	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Alumno alumno, @PathVariable Long id) {
		Optional<Alumno> optionalAlumno = service.findById(id);
		if (optionalAlumno.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Alumno alumnoDb = optionalAlumno.get();
		alumnoDb.setNombre(alumno.getNombre());
		alumnoDb.setApellido(alumno.getApellido());
		alumnoDb.setEmail(alumno.getEmail());
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(alumnoDb));
	}
	
	@GetMapping("/filter/{value}")
	public ResponseEntity<?> filter(@PathVariable(name = "value") String term ) {
		return ResponseEntity.ok().body(service.findByNombreOrApellido(term));
	}



}
