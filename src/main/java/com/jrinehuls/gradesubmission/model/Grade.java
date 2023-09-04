package com.jrinehuls.gradesubmission.model;

import com.jrinehuls.gradesubmission.annotations.Score;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"student_id", "course_id"})
})
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Score
    @Column(nullable = false)
    private String score;

    @ManyToOne(optional = false)
    @JoinColumn(name = "student_id") // , referencedColumnName = "id"
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

}
