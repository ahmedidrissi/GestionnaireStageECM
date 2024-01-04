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
    private Long siretNumber;

    @Column(name = "forme_juridique", nullable = false)
    private String legalForm;
    
    @Column(name = "raison_sociale", nullable = false)
    private String businessName;

    @Column(name = "addresse", nullable = false)
    private String address;

    @Column(name = "ville", nullable = false)
    private String  city;

    @Column(name = "code_postal", nullable = false)
    private int postalCode;

    @Column(name = "telephone_tuteur", nullable = false)
    private String tutorPhoneNumber;
    
    @Column(name = "fax", nullable = false)
    private String fax;
    
    @Column(name = "contact", nullable = false)
    private String contact;
    
    @Column(name = "telephone_contact", nullable = false)
    private String contactPhoneNumber;

    @Column(name = "email", nullable = false)
    private String email;

    public Entreprise(
        String legalForm,
        String businessName,
        String address,
        String city,
        int postalCode,
        String tutorPhoneNumber,
        String fax,
        String contact,
        String contactPhoneNumber,
        String email
    ) {
        this.legalForm = legalForm;
        this.businessName = businessName;
        this.address = address;
        this.city = city;
        this.postalCode = postalCode;
        this.tutorPhoneNumber = tutorPhoneNumber;
        this.fax = fax;
        this.contact = contact;
        this.contactPhoneNumber = contactPhoneNumber;
        this.email = email;
    }
}
