package com.example.gestionnairestageecm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gestionnairestageecm.models.Entreprise;
import com.example.gestionnairestageecm.repositories.EntrepriseRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EntrepriseService {

    @Autowired
    private EntrepriseRepository entrepriseRepository; 
    
    public List<Entreprise> getAllEntreprises() {
        return entrepriseRepository.findAll();
    }

    public Entreprise getEntrepriseBySiretNumber(Long siretNumber) {
        return entrepriseRepository.findBySiretNumber(siretNumber).get();
    }

    public Entreprise getEntrepriseByBusinessName(String businessName) {
        return entrepriseRepository.findByBusinessName(businessName).get();
    }

    public Entreprise saveEntreprise(Entreprise entreprise) {
        return entrepriseRepository.save(entreprise);
    }

    public Entreprise updateEntreprise(Long siretNumber, Entreprise newEntreprise) {
        entrepriseRepository.deleteById(siretNumber);
        return entrepriseRepository.save(newEntreprise);
    }

    public void deleteEntreprise(Long siretNumber) {
        entrepriseRepository.deleteById(siretNumber);
    }
}
