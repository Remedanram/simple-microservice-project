package com.sample.school.repository;

import com.sample.school.entity.School;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepository extends JpaRepository<School,Long> {
    School getSchoolById(Long schoolId);
}
