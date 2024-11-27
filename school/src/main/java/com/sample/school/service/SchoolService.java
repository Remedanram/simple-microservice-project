package com.sample.school.service;

import com.sample.school.entity.School;
import com.sample.school.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SchoolService {
    private final SchoolRepository repository;

    public School registerSchool(School school) {
        School school1= new School();
        school1.setSchoolName(school.getSchoolName());
        school1.setSchoolAddress(school.getSchoolAddress());
        return repository.save(school1);
    }

    public List<School> getSchools() {
        return repository.findAll();
    }
    public Optional<School> getBySchoolId(Long schoolId) {
        return repository.findById(schoolId);
    }
}
