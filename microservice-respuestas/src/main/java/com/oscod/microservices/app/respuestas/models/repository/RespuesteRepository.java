package com.oscod.microservices.app.respuestas.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.oscod.microservices.app.respuestas.models.entity.Respuesta;

public interface RespuesteRepository extends CrudRepository<Respuesta, Long> {

}
