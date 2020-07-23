package com.oscod.microservices.app.cursos.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.oscod.microservices.app.cursos.models.entity.Curso;
import com.oscod.microservices.app.cursos.services.CursoService;
import com.oscod.microservices.commons.alumnos.models.entity.Alumno;
import com.oscod.microservices.commons.controllers.CommonController;
import com.oscod.microservices.commons.examenes.models.entity.Examen;

@RestController
public class CursoController extends CommonController<Curso, CursoService> {

	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@Valid @RequestBody Curso curso, BindingResult result, @PathVariable Long id) {
		// Se validan los datos a guardar
		if (result.hasErrors()) {
			return this.validar(result);
		}

		Optional<Curso> optionalCurso = service.findById(id);
		if (optionalCurso.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Curso cursoDB = optionalCurso.get();
		cursoDB.setNombre(curso.getNombre());
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(cursoDB));
	}

	@PutMapping("/{id}/asignar-alumnos")
	public ResponseEntity<?> asignarAlumnos(@RequestBody List<Alumno> alumnos, @PathVariable Long id) {
		Optional<Curso> optionalCurso = service.findById(id);
		if (optionalCurso.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Curso cursoDB = optionalCurso.get();
		alumnos.forEach(a -> cursoDB.addAlumno(a));
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(cursoDB));
	}

	@PutMapping("/{id}/eliminar-alumno")
	public ResponseEntity<?> eliminarAlumno(@RequestBody Alumno alumno, @PathVariable Long id) {
		Optional<Curso> optionalCurso = service.findById(id);
		if (optionalCurso.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Curso cursoDB = optionalCurso.get();
		cursoDB.removeAlumno(alumno);
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(cursoDB));
	}

	@GetMapping("/alumno/{id}")
	public ResponseEntity<?> buscarAlumnoPorId(@PathVariable Long id) {
		Curso cursoCurrent = service.findCursoByAlumnoId(id);
		if (cursoCurrent != null) {
			return ResponseEntity.ok().body(cursoCurrent);
		}
		return ResponseEntity.noContent().build();

	}

	@PutMapping("/{id}/asignar-examenes")
	public ResponseEntity<?> asignarExamenes(@RequestBody List<Examen> examenes, @PathVariable Long id) {
		Optional<Curso> optionalCurso = service.findById(id);
		if (optionalCurso.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Curso cursoDB = optionalCurso.get();
		examenes.forEach(examen -> cursoDB.addExamen(examen));
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(cursoDB));
	}

	@PutMapping("/{id}/eliminar-examen")
	public ResponseEntity<?> eliminarExamen(@RequestBody Examen examen, @PathVariable Long id) {
		Optional<Curso> optionalCurso = service.findById(id);
		if (optionalCurso.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Curso cursoDB = optionalCurso.get();
		cursoDB.removeExamen(examen);
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(cursoDB));
	}
}
