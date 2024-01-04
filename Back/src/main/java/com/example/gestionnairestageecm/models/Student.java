package com.example.gestionnairestageecm.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "etudiant")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id", nullable = false)
    private Long studentId;

    @Column(name = "nom", nullable = false)
    private String firstName;

    @Column(name = "prenom", nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String email;

    @Column(name = "sexe", nullable = false)
    private String gender;

    @Column(name = "date_naissance", nullable = false)
    private String dateOfBirth;

    @Column(name = "adresse", nullable = false)
    private String address;

    @Column(name = "ville", nullable = false)
    private String city;

    @Column(name = "code_postal", nullable = false)
    private String postalCode;

    @Column(name = "telephone", nullable = false)
    private String phoneNumber;

    @Column(name = "promo", nullable = false)
    private String promo;

    @Column(name = "numero_promo", nullable = false)
    private String promoNumber;

    @Column(name = "mention")
    private String mention;
    
    public Student(
        String firstName,
        String lastName,
        String email,
        String gender,
        String dateOfBirth,
        String address,
        String city,
        String postalCode,
        String phoneNumber,
        String promo,
        String promoNumber,
        String mention
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.city = city;
        this.postalCode = postalCode;
        this.phoneNumber = phoneNumber;
        this.promo = promo;
        this.promoNumber = promoNumber;
        this.mention = mention;
    }
    
}
