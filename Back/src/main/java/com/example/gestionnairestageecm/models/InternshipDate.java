package com.example.gestionnairestageecm.models;

import java.time.LocalDate;

import com.example.gestionnairestageecm.enumerations.InternshipType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity(name = "dates_stages")
public class InternshipDate {

    @Enumerated(EnumType.STRING)
    @Column(name = "type_stage", nullable = false)
    private InternshipType internshipType;

    @Column(name = "annee", nullable = false)
    private int year;

    @Column(name = "date_debut", nullable = false)
    private LocalDate startDate;

    @Column(name = "date_fin", nullable = false)
    private LocalDate endDate;
}
