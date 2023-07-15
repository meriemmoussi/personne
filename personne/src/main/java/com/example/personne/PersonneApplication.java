package com.example.personne;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;
@SpringBootApplication
@EnableOpenApi
public class PersonneApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonneApplication.class, args);
	}

}
