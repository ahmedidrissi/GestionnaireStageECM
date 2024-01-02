package com.example.gestionnairestageecm.student;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StudentService {
    private StudentRepository studentRepository; 
    
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
