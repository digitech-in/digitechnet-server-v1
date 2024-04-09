package com.mc.digitechin.digitechin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DigitechInApplication {

	public static void main(String[] args) {
		SpringApplication.run(DigitechInApplication.class, args);
	}

}
