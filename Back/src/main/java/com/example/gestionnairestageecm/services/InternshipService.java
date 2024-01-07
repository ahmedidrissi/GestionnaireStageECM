package com.example.gestionnairestageecm.services;

import com.example.gestionnairestageecm.models.Internship;
import com.example.gestionnairestageecm.models.Professor;
import com.example.gestionnairestageecm.repositories.InternshipRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@AllArgsConstructor
public class InternshipService {
    private InternshipRepository internshipRepository;

    public List<Internship> getAllInternships(){ return internshipRepository.findAll();}
    public Internship getInternshipById(Long internshipId) {
        return internshipRepository.findById(internshipId).get();
    }

    public Internship getBeyProfIdAndTutorId(Long profId,Long tutorId){
        return internshipRepository.findByProfessorIdAndTutorId(profId,tutorId).get();
    }

    public List<Internship> getBySiretNumber(Long siretNumber){
        return internshipRepository.findBySiretNumber(siretNumber);
    }
    public Internship saveInternship(Internship internship) {
        return internshipRepository.save(internship);
    }

    public Internship updateInternship(Long internshipId, Internship newInternship) {
        Internship internship = internshipRepository.findById(internshipId).get();
        internship.setInternshipType(newInternship.getInternshipType());
        internship.setAppreciation(newInternship.getAppreciation());
        internship.setPromo(newInternship.getPromo());
        internship.setPromoNumber(newInternship.getPromoNumber());
        internship.setYear(newInternship.getYear());
        internship.setProfessorId(newInternship.getProfessorId());
        internship.setSiretNumber(newInternship.getSiretNumber());
        internship.setTutorId(newInternship.getTutorId());
        return internshipRepository.save(internship);
    }

    public void deleteInternship(Long internshipId) {
        internshipRepository.deleteById(internshipId);
    }
}
