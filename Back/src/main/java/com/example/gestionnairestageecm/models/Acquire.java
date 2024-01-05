package com.example.gestionnairestageecm.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public final class Acquire {
    private InternshipType internshipType;
    private Skill skill;
    private int requiredLevel;
}