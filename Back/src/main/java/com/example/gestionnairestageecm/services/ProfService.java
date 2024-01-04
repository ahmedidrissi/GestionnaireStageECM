package com.example.gestionnairestageecm.services;

import com.example.gestionnairestageecm.models.Prof;
import com.example.gestionnairestageecm.repositories.ProfRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;


import static java.lang.Boolean.TRUE;
import static org.springframework.data.domain.PageRequest.of;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class ProfService {
    private final ProfRepository profRepository;

    //POST methode
     public Prof create(Prof prof){
         log.info("ajouter un nouveau professeur : {}",prof.getFirstName()+prof.getLastName());
         return profRepository.save(prof);
     }

     //GET methode
    public Collection<Prof> Profs(int limit) {
        log.info("afficher la list des professeur");
        return profRepository.findAll(of(0,limit)).toList();
    }


   //GET methode
    public Prof get(Long id) {
        log.info("afficher le professeur avec le numero_prof = {}",id);
        return profRepository.findById(id).get();
    }

    //GET methode
    public Prof getByName(String firstName, String lastName){
         log.info("afficher le professeur avec le nom et prenom = {}",lastName+firstName);
         return profRepository.findByFirstNameAndLastName(firstName,lastName);
    }

    //PUT methode
    public Prof update(Long id ,Prof newprof) {
        log.info("mettre a jour les info du professeur ");
        Prof prof=get(id);
        prof.setFirstName(newprof.getFirstName());
        prof.setLastName(newprof.getLastName());
        prof.setCity(newprof.getCity());
        prof.setAddress(newprof.getAddress());
        prof.setSexe(newprof.getSexe());
        prof.setTelephone(newprof.getTelephone());
        prof.setSchoolPhone(newprof.getSchoolPhone());
        prof.setPostalCode(newprof.getPostalCode());
        prof.setDateDep(newprof.getDateDep());
        prof.setDateEmb(newprof.getDateEmb());
        return profRepository.save(prof);
    }

    //DELETE methode
    public Boolean delete(Long id) {
        log.info("supprimer le prof avec le numero de prof est : {}", id);
        profRepository.deleteById(id);
        return TRUE;
    }

}