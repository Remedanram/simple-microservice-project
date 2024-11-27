package com.sample.student.service;

import com.netflix.discovery.converters.Auto;
import com.sample.student.client.SchoolClient;
import com.sample.student.dto.StudentDetails;
import com.sample.student.model.Student;
import com.sample.student.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    @Autowired
    private StudentRepository repository;
    @Autowired
    private  final SchoolClient schoolClient;
    public List<Student> getAll() {
        return repository.findAll();
    }

    public Student register(Student student) {
        Student student1=new Student();
        student1.setName(student.getName());
        student1.setDepName(student.getDepName());
        student1.setSchoolId(student.getSchoolId());
         return repository.save(student1);

    }

    public StudentDetails getStudentsDetails(Long studentId) {
        Student student=repository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        SchoolClient.School school = schoolClient.getSchoolById(student.getSchoolId());
            return new StudentDetails(
                    student.getId(),
                    student.getName(),
                    student.getDepName(),
                    school.getSchoolName(),
                    school.getSchoolAddress());
    }
}
