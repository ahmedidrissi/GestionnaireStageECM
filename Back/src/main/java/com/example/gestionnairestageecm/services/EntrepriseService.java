package com.example.gestionnairestageecm.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.gestionnairestageecm.models.Entreprise;
import com.example.gestionnairestageecm.repositories.EntrepriseRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EntrepriseService {
    private EntrepriseRepository entrepriseRepository; 
    
    public List<Entreprise> getAllEntreprises() {
        return entrepriseRepository.findAll();
    }

    public Entreprise getEntrepriseById(Long numero_siret) {
        return entrepriseRepository.findById(numero_siret).get();
    }


    public Entreprise saveEntreprise(Entreprise  entreprise) {
        return entrepriseRepository.save(entreprise);
    }

    public Entreprise updateEntreprise(Long numero_siret, Entreprise newEntreprise) {
        Entreprise entreprise =  entrepriseRepository.findById(numero_siret).get();
        entreprise.setLegalform(newEntreprise.getLegalform());
        entreprise.setBusiness_name((newEntreprise.getBusiness_name()));
        entreprise.setAddress(newEntreprise.getAddress());
        entreprise.setCity(newEntreprise.getCity());
        entreprise.setPostalCode(newEntreprise.getPostalCode());
        entreprise.setFax(newEntreprise.getFax());
        entreprise.setPhoneNumber(newEntreprise.getPhoneNumber());
        entreprise.setFax(newEntreprise.getFax());
        entreprise.setContact(newEntreprise.getContact());
        entreprise.setPhoneContact(newEntreprise.getPhoneContact());
        entreprise.setEmail(newEntreprise.getEmail());
        return entrepriseRepository.save(entreprise);
    }

    public void deleteEntreprise(Long numero_siret) {
        entrepriseRepository.deleteById(numero_siret);
    }
}
