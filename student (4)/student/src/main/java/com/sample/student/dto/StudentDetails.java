package com.sample.student.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDetails {
    private Long studentId;
    private String name;
    private String depName;
    private String schoolName;
    private String schoolAddress;
}
