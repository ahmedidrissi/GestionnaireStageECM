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
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero_professeur", nullable = false)
    private Long professorId;

    @Column(name = "prenom", nullable = false)
    private String firstName;

    @Column(name = "nom", nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String email;
    
    @Column(name = "sexe", nullable = false)
    private String gender;

    @Column(name = "adresse", nullable = false)
    private String address;

    @Column(name = "ville", nullable = false)
    private String city;

    @Column(name = "code_postal", nullable = false)
    private int postalCode;

    @Column(name = "telephone_ecole", nullable = false)
    private String schoolPhoneNumber;

    @Column(name = "telephone_mobile", nullable = false)
    private String phoneNumber;

    @Column(name = "date_embauche", nullable = false)
    private LocalDate hiringDate;
    @Column(name = "date_depart", nullable = false)
    private LocalDate leavingDate;

    public Professor(
        String firstName,
        String lastName,
        String email,
        String gender,
        String address,
        String city,
        int postalCode,
        String schoolPhoneNumber,
        String phoneNumber,
        LocalDate hiringDate,
        LocalDate leavingDate
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.address = address;
        this.city = city;
        this.postalCode = postalCode;
        this.schoolPhoneNumber = schoolPhoneNumber;
        this.phoneNumber = phoneNumber;
        this.hiringDate = hiringDate;
        this.leavingDate = leavingDate;
    }
}