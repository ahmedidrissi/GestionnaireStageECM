package com.example.gestionnairestageecm.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.gestionnairestageecm.models.Student;
import com.example.gestionnairestageecm.repositories.StudentRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StudentService {
    private StudentRepository studentRepository; 
    
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
