package com.oscod.microservices.app.examenes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableEurekaClient
@SpringBootApplication
public class MicroserviceExamenesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceExamenesApplication.class, args);
	}

}
