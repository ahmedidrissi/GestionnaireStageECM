package com.example.gestionnairestageecm.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "professeur")
public class Prof {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero_professeur", nullable = false)
    private Long profId;
    @Column(name = "nom", nullable = false)
    private String lastName;
    @Column(name = "prenom", nullable = false)
    private String firstName;
    @Column(name = "sexe", nullable = false)
    private String sexe;
    @Column(name = "adresse", nullable = false)
    private String address;
    @Column(name = "ville", nullable = false)
    private String city;
    @Column(name = "code_postal", nullable = false)
    private int postalCode;
    @Column(name = "telephone_ecole", nullable = false)
    private String schoolPhone;
    @Column(name = "telephone_mobile", nullable = false)
    private String telephone;
    @Column(name = "date_embauche", nullable = false)
    private LocalDate dateEmb;
    @Column(name = "date_depart", nullable = false)
    private LocalDate dateDep;

    public Prof(String lastName, String firstName, String sexe, String address, String city, int postalCode, String schoolPhone, String telephone, LocalDate dateEmb, LocalDate dateDep) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.sexe = sexe;
        this.address = address;
        this.city = city;
        this.postalCode = postalCode;
        this.schoolPhone = schoolPhone;
        this.telephone = telephone;
        this.dateEmb = dateEmb;
        this.dateDep = dateDep;
    }
}
