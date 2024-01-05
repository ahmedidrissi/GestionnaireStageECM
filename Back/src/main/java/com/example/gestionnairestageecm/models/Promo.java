package com.example.gestionnairestageecm.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity(name = "promos")
public class Promo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_promo", nullable = false)
    private Long promoId;

    @Column(name = "annee", nullable = false)
    private int year;

    @Column(name = "code_professeur", nullable = false)
    private long professorId;

    @Column(name = "nombre_inscrits", nullable = false)
    private int registredNumber;

    @Column(name = "nombre_reçus", nullable = false)
    private int receiptsNumber;
}