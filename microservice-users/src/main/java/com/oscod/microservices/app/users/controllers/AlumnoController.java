package com.oscod.microservices.app.users.controllers;

import java.io.IOException;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.oscod.microservices.app.users.services.AlumnoService;
import com.oscod.microservices.commons.alumnos.models.entity.Alumno;
import com.oscod.microservices.commons.controllers.CommonController;

@RestController
public class AlumnoController extends CommonController<Alumno, AlumnoService> {

	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@Valid @RequestBody Alumno alumno,  BindingResult result, @PathVariable Long id) {
		// Se validan los datos a guardar
		if (result.hasErrors()) {
			return this.validar(result);
		}

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
	public ResponseEntity<?> filter(@PathVariable(name = "value") String term) {
		return ResponseEntity.ok().body(service.findByNombreOrApellido(term));
	}
	
	@PutMapping("/editarConFoto/{id}")
	public ResponseEntity<?> editarConFoto(@Valid Alumno alumno,  BindingResult result, @PathVariable Long id,  @RequestParam MultipartFile archivo) {
		// Se validan los datos a guardar
		if (result.hasErrors()) {
			return this.validar(result);
		}
		
		Optional<Alumno> optionalAlumno = service.findById(id);
		if (optionalAlumno.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Alumno alumnoDb = optionalAlumno.get();
		alumnoDb.setNombre(alumno.getNombre());
		alumnoDb.setApellido(alumno.getApellido());
		alumnoDb.setEmail(alumno.getEmail());
		if (archivo != null && !archivo.isEmpty()) {
			try {
				alumnoDb.setFoto(archivo.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(alumnoDb));
	}
	

	@PostMapping("/crearConFoto")
	public ResponseEntity<?> crearConFoto(@Valid Alumno entity, BindingResult result, @RequestParam MultipartFile archivo) {
		// TODO Auto-generated method stub
		if (archivo != null && !archivo.isEmpty()) {
			try {
				entity.setFoto(archivo.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return super.crear(entity, result);
	}
	
	@GetMapping("/uploads/img/{id}")
	public ResponseEntity<?> verFoto(@PathVariable Long id) {
		Optional<Alumno> optionalAlumno = service.findById(id);
		if (optionalAlumno.isEmpty() ||optionalAlumno.get().getFoto() == null) {
			return ResponseEntity.notFound().build();
		}
		
		Resource img = new ByteArrayResource(optionalAlumno.get().getFoto());
		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(img);
	}

}
