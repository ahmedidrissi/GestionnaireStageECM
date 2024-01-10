package com.example.gestionnairestageecm.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Stage")
public class Internship {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_stage",nullable = false)
    private Long internshipId;
    @Column(name = "promo",nullable = false)
    private int promo;
    @Column(name = "numero_promo",nullable = false)
    private String promoNumber;
    @Column(name = "id_professeur",nullable = false)
    private Long professorId;
    @Column(name = "id_tuteur",nullable = false)
    private Long tutorId;
    @Column(name = "numero_de_siret",nullable = false)
    private Long siretNumber;
    @Column(name = "type_stage",nullable = false)
    private int internshipType;
    @Column(name = "annee_stage",nullable = false)
    private int year;
    @Column(name = "appreciation")
    private String appreciation;

    public Internship(int promo, String promoNumber, Long professorId, Long tutorId, Long siretNumber, int internshipType, int year, String appreciation) {
        this.promo = promo;
        this.promoNumber = promoNumber;
        this.professorId = professorId;
        this.tutorId = tutorId;
        this.siretNumber = siretNumber;
        this.internshipType = internshipType;
        this.year = year;
        this.appreciation = appreciation;
    }
}
