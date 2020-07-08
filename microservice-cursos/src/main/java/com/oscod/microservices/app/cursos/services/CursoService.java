/**
 * 
 */
package com.oscod.microservices.app.cursos.services;

import com.oscod.microservices.app.cursos.models.entity.Curso;
import com.oscod.microservices.commons.services.CommonService;

/**
 * @author bchavez
 *
 */
public interface CursoService extends CommonService<Curso> {
	
	/**
	 * 
	 * @param id del alumno
	 * @return Retorna el curso con los alumnos asignados al mismo
	 */
	public Curso findCursoByAlumnoId(Long id);

}
