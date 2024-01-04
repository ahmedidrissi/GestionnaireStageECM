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
	// 		studentRepository.save(new Student("ahmed", "idrissi", "idrissiahmed2002@gmail.com"));
	// 	};
	// }

}
