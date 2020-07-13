package com.oscod.microservices.app.cursos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({ "com.oscod.microservices.commons.alumnos.models.entity",
		"com.oscod.microservices.app.cursos.models.entity", "com.oscod.microservices.commons.examenes.models.entity" })
public class MicroserviceCursosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceCursosApplication.class, args);
	}

}
