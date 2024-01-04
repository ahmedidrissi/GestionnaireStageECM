package com.example.gestionnairestageecm.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.gestionnairestageecm.models.Student;
import com.example.gestionnairestageecm.services.StudentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
@AllArgsConstructor
public class EntrepriseController {
    private EntrepriseService entrepriseService;

    @GetMapping("/entrepriseServices")
    public List<Entreprise> getAllEntreprises() {
        return entrepriseService.getAllEntreprises();
    }

    @GetMapping("/Entreprises/{numero_siret}")
    public Entreprise getEntrepriseById(@PathVariable Long numero_siret) {
        return entrepriseService.getEntrepriseById(numero_siret);
    }

    @PostMapping("/Entreprises/new")
    public void saveEntreprise(@RequestBody Entreprise entreprise) {
        entrepriseService.saveEntreprise(entreprise);
    }

    @PutMapping("/Entreprises/update/{numero_siret}")
    public void updateEntreprise(@PathVariable Long numero_siret, @RequestBody Entreprise newEntreprise) {
        entrepriseService.updateEntreprise(newEntreprise);
    }

    @DeleteMapping("/Entreprises/delete/{numero_siret}")
    public void deleteEntreprise(@PathVariable Long numero_siret) {
        entrepriseService.deleteEntreprise(numero_siret);
    }
    
}
