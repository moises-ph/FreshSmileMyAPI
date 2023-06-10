package com.Fresh.ProyectoFormativo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
@EntityScan("com.Fresh.ProyectoFormativo.Entity")
public class ProyectoFormativoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoFormativoApplication.class, args);
	}

}
