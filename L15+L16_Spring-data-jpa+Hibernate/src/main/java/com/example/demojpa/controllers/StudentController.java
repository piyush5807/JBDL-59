package com.example.demojpa.controllers;

import com.example.demojpa.models.Student;
import com.example.demojpa.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @PostMapping("/student/{studentName}")
    public Student createStudent(@PathVariable("studentName") String studentName){
        Student student = Student.builder()
                .name(studentName)
                .build();
        return studentRepository.save(student);
    }
}
