package com.example.gestionnairestageecm.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity(name = "promos")
public class Promo {

    @Column(name = "annee", nullable = false)
    private int year;

    @Column(name = "code_professeur", nullable = false)
    private long professorId;

    @Column(name = "nombre_inscrits", nullable = false)
    private int registredNumber;

    @Column(name = "nombre_reçus", nullable = false)
    private int receiptsNumber;
}