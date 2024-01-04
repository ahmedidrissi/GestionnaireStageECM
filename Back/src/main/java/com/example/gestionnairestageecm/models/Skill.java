package com.example.gestionnairestageecm.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Skill {

    ACHA("Organisation d'un rayon", "Savoir organiser rationnellement un rayon"),
    GSTO("Gestion des stocks", "Mettre en œuvre une gestion des stocks"),
    PCOM("Politique commerciale", "Comprendre et participer à la mise en œuvre d'une politique commerciale"),
    TEXC("Tableur Grapheur", "Mettre en œuvre les principales fonctionnalités d'un tableur"),
    TTWO("Traitement de texte", "Mettre en œuvre les principales fonctionnalités d'un traitement de texte"),
    VEN1("Accueil clientèle", "Repérer les différents types de clientèle"),
    VEN2("Connaître le produit", "Argumenter en fonction des caractéristiques techniques du produit");

    private String Label;
    private String Description;
}
