package com.example.gestionnairestageecm.models;

import java.time.LocalDate;

import com.example.gestionnairestageecm.enumerations.InternshipType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity(name = "dates_stages")
public class InternshipDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "date_stage_id", nullable = false)
    private Long internshipDateId;

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
