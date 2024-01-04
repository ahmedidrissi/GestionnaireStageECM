package com.example.gestionnairestageecm.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.gestionnairestageecm.models.Student;
import com.example.gestionnairestageecm.repositories.StudentRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EntrepriseService {
    private EntrepriseRepository EntrepriseRepository; 
    
    public List<Student> getAllEntreprises() {
        return entrepriseRepository.findAll();
    }

    public Entreprise getEntrepriseById(Long numero_siret) {
        return entrepriseRepository.findById(numero_siret).get();
    }


    public Entreprise saveEntreprise(Entreprise  entreprise) {
        return entrepriseRepository.save(entreprise);
    }

    public Entreprise updateEntreprise(Entreprise newEntreprise) {
        return entrepriseRepository.save(newEntreprise);
    }

    public void deleteEntreprise(Long numero_siret) {
        entrepriseRepository.deleteById(numero_siret);
    }
}
