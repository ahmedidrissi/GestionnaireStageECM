package com.example.gestionnairestageecm.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.gestionnairestageecm.models.Student;
import com.example.gestionnairestageecm.services.StudentService;


@Controller
@AllArgsConstructor
public class StudentController {
    private StudentService studentService;

    @GetMapping("students")
    public List<Student> listStudents() {
        return studentService.getAllStudents();
    }
}
