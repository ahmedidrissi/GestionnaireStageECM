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

    public Student getStudentById(Long studentId) {
        return studentRepository.findById(studentId).get();
    }

    // public Student getStudentByEmail(String email) {
    //     return studentRepository.findByEmail(email).get();
    // }

    // public Student getStudentByName(String firstName, String lastName) {
    //     return studentRepository.findByName(firstName, lastName).get();
    // }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(Student newStudent) {
        return studentRepository.save(newStudent);
    }

    public void deleteStudent(Long studentId) {
        studentRepository.deleteById(studentId);
    }
}
