package com.example.gestionnairestageecm.controllers;

import java.util.List;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.gestionnairestageecm.models.Entreprise;
import com.example.gestionnairestageecm.services.EntrepriseService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RequestMapping("/entreprises")
@RestController
@AllArgsConstructor
public class EntrepriseController {
    private EntrepriseService entrepriseService;

    @GetMapping("/list")
    public List<Entreprise> getAllEntreprises() {
        return entrepriseService.getAllEntreprises();
    }

    @GetMapping("/id={numero_siret}")
    public Entreprise getEntrepriseById(@PathVariable Long numero_siret) {
        return entrepriseService.getEntrepriseById(numero_siret);
    }

    @PostMapping("/new")
    public void saveEntreprise(@RequestBody Entreprise entreprise) {
        entrepriseService.saveEntreprise(entreprise);
    }

    @PutMapping("/update/id={numero_siret}")
    public void updateEntreprise(@PathVariable Long numero_siret, @RequestBody Entreprise newEntreprise) {
        entrepriseService.updateEntreprise(numero_siret, newEntreprise);
    }

    @DeleteMapping("/delete/id={numero_siret}")
    public void deleteEntreprise(@PathVariable Long numero_siret) {
        entrepriseService.deleteEntreprise(numero_siret);
    }
    
}
