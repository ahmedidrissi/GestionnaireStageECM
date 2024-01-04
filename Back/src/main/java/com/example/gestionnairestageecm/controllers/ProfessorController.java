package com.example.gestionnairestageecm.controllers;

import java.util.List;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.gestionnairestageecm.models.Professor;
import com.example.gestionnairestageecm.services.ProfessorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@AllArgsConstructor
@RestController
@RequestMapping("/professors")
public class ProfessorController {

    private final ProfessorService professorService;


    @GetMapping("/list")
    public List<Professor> getAllProfs() {
        return professorService.getAllProfessors();
    }

    @GetMapping("/id={professorId}")
    public Professor getProfessorById(@PathVariable Long professorId) {
        return professorService.getProfessorById(professorId);
    }
    
    @GetMapping("/name={firstName}+{lastName}")
    public Professor getProfessorByName(@PathVariable String firstName, @PathVariable String lastName) {
        return professorService.getProfessorByFirstNameAndLastName(firstName, lastName);
    }

    @PutMapping("/update/id={professorId}")
    public void updateProfessor(@PathVariable Long professorId, @RequestBody Professor newProfessor) {
        professorService.updateProfessor(professorId, newProfessor);
    }
    
    @PostMapping("/new")
    public void saveProfessor(@RequestBody Professor professor) {
        professorService.saveProfessor(professor);
    }

    @DeleteMapping("/delete/id={professorId}")
    public void deleteProfessor(@PathVariable Long professorId) {
        professorService.deleteProfessor(professorId);
    }
    
}