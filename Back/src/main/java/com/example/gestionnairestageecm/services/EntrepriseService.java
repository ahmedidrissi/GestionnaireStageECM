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

    public Entreprise getEntrepriseById(Long siretNumber) {
        return entrepriseRepository.findById(siretNumber).get();
    }

    public Entreprise saveEntreprise(Entreprise entreprise) {
        return entrepriseRepository.save(entreprise);
    }

    public Entreprise updateEntreprise(Long siretNumber, Entreprise newEntreprise) {
        Entreprise entreprise =  entrepriseRepository.findById(siretNumber).get();
        entreprise.setLegalForm(newEntreprise.getLegalForm());
        entreprise.setBusinessName((newEntreprise.getBusinessName()));
        entreprise.setAddress(newEntreprise.getAddress());
        entreprise.setCity(newEntreprise.getCity());
        entreprise.setPostalCode(newEntreprise.getPostalCode());
        entreprise.setFax(newEntreprise.getFax());
        entreprise.setTutorPhoneNumber(newEntreprise.getTutorPhoneNumber());
        entreprise.setFax(newEntreprise.getFax());
        entreprise.setContact(newEntreprise.getContact());
        entreprise.setContactPhoneNumber(newEntreprise.getContactPhoneNumber());
        entreprise.setEmail(newEntreprise.getEmail());
        return entrepriseRepository.save(entreprise);
    }

    public void deleteEntreprise(Long siretNumber) {
        entrepriseRepository.deleteById(siretNumber);
    }
}
