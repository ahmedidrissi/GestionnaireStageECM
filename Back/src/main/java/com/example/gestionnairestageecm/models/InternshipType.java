package com.example.gestionnairestageecm.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum InternshipType {

    FIRST_YEAR(11, 4),
    SECOND_YEAR_1ST(21, 4),
    SECOND_YEAR_2ND(21, 8),
    THIRD_YEAR_1ST(31, 2),
    THIRD_YEAR_2ND(32, 12);

    private int typeCode;
    private int weeksNumber;
}


