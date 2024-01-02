package com.example.gestionnairestageecm.student;

import java.util.List;

import org.springframework.stereotype.Controller;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class StudentController {
    private StudentService studentService;

    public List<Student> listStudents() {
        return studentService.getAllStudents();
    }
}
