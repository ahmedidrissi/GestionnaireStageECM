package com.example.gestionnairestageecm.models;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class InternshipDate {
    private InternshipType internshipType;
    private int year;
    private LocalDate startDate;
    private LocalDate endDate;
}
