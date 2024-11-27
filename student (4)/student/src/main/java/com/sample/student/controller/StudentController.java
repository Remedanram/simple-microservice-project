package com.sample.student.controller;

import com.netflix.discovery.converters.Auto;
import com.sample.student.dto.StudentDetails;
import com.sample.student.model.Student;
import com.sample.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    @Autowired
    private StudentService service;
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Student> getAll(){
        return service.getAll();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student register(@RequestBody  Student student){
        return service.register(student);
    }
    @GetMapping("/details/{StudentId}")
    public StudentDetails getStudentsDetails(@PathVariable Long StudentId){
        return service.getStudentsDetails(StudentId);

    }

}
