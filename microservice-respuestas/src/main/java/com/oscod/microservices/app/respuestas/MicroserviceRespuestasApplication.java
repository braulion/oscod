package com.oscod.microservices.app.respuestas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MicroserviceRespuestasApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceRespuestasApplication.class, args);
	}

}
