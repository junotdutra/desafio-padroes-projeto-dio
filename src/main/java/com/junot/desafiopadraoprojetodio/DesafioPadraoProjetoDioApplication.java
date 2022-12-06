package com.junot.desafiopadraoprojetodio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients
@SpringBootApplication
public class DesafioPadraoProjetoDioApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioPadraoProjetoDioApplication.class, args);
	}

}
