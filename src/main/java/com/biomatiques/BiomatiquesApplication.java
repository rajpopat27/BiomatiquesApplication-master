package com.biomatiques;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BiomatiquesApplication {

	public static void main(String[] args) {
		SpringApplication.run(BiomatiquesApplication.class, args);
	}
}

