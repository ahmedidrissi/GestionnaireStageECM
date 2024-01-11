package com.example.gestionnairestageecm.models;

import com.example.gestionnairestageecm.enumerations.InternshipType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "stages")
public class Internship {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_stage",nullable = false)
    private Long internshipId;
    @Column(name = "promo",nullable = false)
    private int promo;
    @Column(name = "numero_promo",nullable = false)
    private String promoNumber;
    @Column(name = "professeur",nullable = false)
    private Long professor;
    @Column(name = "tuteur",nullable = false)
    private Long tutor;
    @Column(name = "entreprise",nullable = false)
    private Long company;
    @Column(name = "type_stage",nullable = false)
    private int internshipType;
    @Column(name = "annee_stage",nullable = false)
    private int year;
    @Column(name = "appreciation")
    private String appreciation;

    public Internship(int promo, String promoNumber, Long professor, Long tutor, Long company, int internshipType, int year, String appreciation) {
        this.promo = promo;
        this.promoNumber = promoNumber;
        this.professor = professor;
        this.tutor = tutor;
        this.company = company;
        this.internshipType = internshipType;
        this.year = year;
        this.appreciation = appreciation;
    }
}
