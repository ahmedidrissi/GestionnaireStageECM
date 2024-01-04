package com.example.gestionnairestageecm.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Promo {
    private int year;
    private long professorId;
    private int registredNumber;
    private int receiptsNumber;
}