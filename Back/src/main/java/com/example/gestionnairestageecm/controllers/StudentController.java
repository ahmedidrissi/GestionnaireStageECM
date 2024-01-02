package com.example.gestionnairestageecm.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.gestionnairestageecm.models.Student;
import com.example.gestionnairestageecm.services.StudentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;





@Controller
@AllArgsConstructor
public class StudentController {
    private StudentService studentService;

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/students/{studentId}")
    public Student getStudentById(@PathVariable Long studentId) {
        return studentService.getStudentById(studentId);
    }

    // @GetMapping("/students/{email}")
    // public Student getStudentByEmail(@PathVariable String email) {
    //     return studentService.getStudentByEmail(email);
    // }

    // @GetMapping("/students/{firstName}/{lastName}")
    // public Student getStudentByName(@PathVariable String firstName, @PathVariable String lastName) {
    //     return studentService.getStudentByName(firstName, lastName);
    // }

    @PostMapping("/students/new")
    public void saveStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
    }

    @PutMapping("/students/update/{studentId}")
    public void updateStudent(@PathVariable String studentId, @RequestBody Student newStudent) {
        studentService.updateStudent(newStudent);
    }

    @DeleteMapping("/students/delete/{studentId}")
    public void deleteStudent(@PathVariable Long studentId) {
        studentService.deleteStudent(studentId);
    }
    
}
