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
@Entity(name = "entreprise")
public class Entreprise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero_siret", nullable = false)
    private Long numeroSiret;

    
    @Column(name = "legalform", nullable = false)
    private String legalform;
    
    @Column(name = "business_name", nullable = false)
    private String business_name;

    @Column(name = "address", nullable = false)
    private String address;

    
    @Column(name = "city", nullable = false)
    private String  city;


    @Column(name = "postalCode", nullable = false)
    private Integer postalCode;

    // Le téléphone du tuteur de l'étudiant dans l’entreprise

    @Column(name = "phoneNumber", nullable = false)
    private String phoneNumber;

    
    @Column(name = "fax", nullable = false)
    private String fax;

    // Le numéro de téléphone de l’entreprise
    
    @Column(name = "contact", nullable = false)
    private String contact;

    // La personne joignable de l’entreprise
    
    @Column(name = "phoneContact", nullable = false)
    private String phoneContact;

   
    @Column(name = "email", nullable = false)
    private String email;

    public Entreprise(
            String legalform,
            String business_name,
            String address,
            String city,
            Integer postalCode,
            String phoneNumber,
            String fax,
            String contact,
            String phoneContact,
            String email
    ) {
        this.legalform = legalform;
        this.business_name = business_name;
        this.address = address;
        this.city = city;
        this.postalCode = postalCode;
        this.phoneNumber = phoneNumber;
        this.fax = fax;
        this.contact = contact;
        this.phoneContact = phoneContact;
        this.email = email;
    }
}
