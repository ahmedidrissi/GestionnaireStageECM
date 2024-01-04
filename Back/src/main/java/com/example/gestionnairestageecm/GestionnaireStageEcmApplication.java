package com.example.gestionnairestageecm;

import com.example.gestionnairestageecm.models.Prof;
import com.example.gestionnairestageecm.repositories.ProfReposetory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class GestionnaireStageEcmApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionnaireStageEcmApplication.class, args);
	}

	@Bean
	CommandLineRunner run(ProfReposetory profReposetory) {
		return args -> {
			profReposetory.save(new Prof("Mandili", "Adnane", "Male", "123 Main St", "Rabat",
					12345, "123-456-7890", "987-654-3210", LocalDate.of(2022, 1, 1), LocalDate.of(2023, 12, 31)));
			profReposetory.save(new Prof("Doe", "John", "Male", "123 Main St", "Rabat",
					12345, "123-456-7890", "987-654-3210", LocalDate.of(2022, 1, 1), LocalDate.of(2023, 12, 31)));
		};
	}
}
