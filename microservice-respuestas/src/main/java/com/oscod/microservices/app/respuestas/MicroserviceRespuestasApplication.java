package com.oscod.microservices.app.respuestas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({ "com.oscod.microservices.app.respuestas.models.entity",
		"com.oscod.microservices.commons.alumnos.models.entity",
		"com.oscod.microservices.commons.examenes.models.entity" })
public class MicroserviceRespuestasApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceRespuestasApplication.class, args);
	}

}
