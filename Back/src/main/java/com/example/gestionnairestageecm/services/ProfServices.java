package com.example.gestionnairestageecm.services;

import com.example.gestionnairestageecm.models.Prof;
import com.example.gestionnairestageecm.repositories.ProfReposetory;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

import static java.lang.Boolean.TRUE;
import static org.springframework.data.domain.PageRequest.of;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class ProfServices {
    private final ProfReposetory profReposetory;

    //POST methode
     public Prof create(Prof prof){
         log.info("ajouter un nouveau professeur : {}",prof.getFirstName()+prof.getLastName());
         return profReposetory.save(prof);
     }

     //GET methode
    public Collection<Prof> Profs(int limit) {
        log.info("afficher la list des professeur");
        return profReposetory.findAll(of(0,limit)).toList();
    }


   //GET methode
    public Prof get(Long id) {
        log.info("afficher le professeur avec le numero_prof = {}",id);
        return profReposetory.findById(id).get();
    }

    //PUT methode
    public Prof update(Prof prof) {
        log.info("mettre a jour les info du professeur ");
        return profReposetory.save(prof);
    }

    //DELETE methode
    public Boolean delete(Long id) {
        log.info("supprimer le prof avec le numero de prof est : {}", id);
        profReposetory.deleteById(id);
        return TRUE;
    }

}
