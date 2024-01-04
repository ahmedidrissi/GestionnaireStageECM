package com.example.gestionnairestageecm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gestionnairestageecm.models.Student;

public interface EntrepriseRepository extends JpaRepository<Entreprise, Long> {

}