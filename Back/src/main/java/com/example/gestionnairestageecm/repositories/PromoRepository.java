package com.example.gestionnairestageecm.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gestionnairestageecm.models.Promo;

public interface PromoRepository extends JpaRepository<Promo, Integer> {

    Optional<Promo> findByYear(int year);
    
}
