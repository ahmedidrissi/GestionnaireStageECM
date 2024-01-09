package com.example.gestionnairestageecm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gestionnairestageecm.models.Entreprise;

import java.util.Optional;

public interface EntrepriseRepository extends JpaRepository<Entreprise, Long> {
    Optional<Entreprise> findBySiretNumber(Long siretNumber);

    Optional<Entreprise> findByBusinessName(String businessName);
}