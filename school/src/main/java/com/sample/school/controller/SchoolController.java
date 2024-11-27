package com.sample.school.controller;

import com.sample.school.entity.School;
import com.sample.school.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/schools")
@RequiredArgsConstructor
public class SchoolController {
    private final SchoolService service;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public School registerSchool(@RequestBody School school){
        return service.registerSchool(school);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<School> getSchool(){
        return service.getSchools();
    }

    @GetMapping("/{schoolId}")
    public Optional<School> getBySchoolId(@PathVariable("schoolId") Long schoolId){
        return service.getBySchoolId(schoolId);

    }

}
