package com.sample.student.client;

import lombok.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(name="School", url="http://localhost:8083/api/v1/schools")
public interface SchoolClient {
    @GetMapping("/{schoolId}")
    School getSchoolById(@PathVariable("schoolId") Long schoolId);

    @Setter
    @Getter
    class School {
        private Long id;
        private String schoolName;
        private String schoolAddress;

    }
}
