package com.jrinehuls.gradesubmission.model;

import com.jrinehuls.gradesubmission.Annotations.GradeValidator;
import com.jrinehuls.gradesubmission.Annotations.Score;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Score
    private String score;

    @ManyToOne(optional = false)
    @JoinColumn(name = "student_id") // , referencedColumnName = "id"
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;




}
