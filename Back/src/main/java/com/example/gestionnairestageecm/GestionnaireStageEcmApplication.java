package com.example.gestionnairestageecm;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.gestionnairestageecm.models.Student;
import com.example.gestionnairestageecm.repositories.StudentRepository;

@SpringBootApplication
public class GestionnaireStageEcmApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionnaireStageEcmApplication.class, args);
	}

	// @Bean
	// CommandLineRunner run(StudentRepository studentRepository) {
	// 	return args -> {
	// 		studentRepository.save(new Student(
	// 			"John",
	// 			"Doe",
	// 			"john.doe@gmail.com",
	// 			"Male",
	// 			"01/01/2000",
	// 			"1234 rue de la rue",
	// 			"Montreal",
	// 			"H1H 1H1",
	// 			"514-123-4567",
	// 			"2020",
	// 			"01",
	// 			"Passable"
	// 		));
	// 	};
	// }

}
