package com.jrinehuls.gradesubmission.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Course {

    private Long id;
    private String subject;
    private String code;
    private String description;


}
