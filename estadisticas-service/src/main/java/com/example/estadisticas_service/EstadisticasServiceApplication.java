package com.example.estadisticas_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EstadisticasServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstadisticasServiceApplication.class, args);
	}

}
