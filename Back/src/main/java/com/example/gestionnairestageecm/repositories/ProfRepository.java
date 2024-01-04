package com.example.gestionnairestageecm.repositories;

import com.example.gestionnairestageecm.models.Prof;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProfRepository extends JpaRepository<Prof,Long> {
    Prof findByFirstNameAndLastName(String firstName, String lastName);
}