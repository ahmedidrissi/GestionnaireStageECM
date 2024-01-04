package com.example.gestionnairestageecm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class GestionnaireStageEcmApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionnaireStageEcmApplication.class, args);
	}

}
