package com.jrinehuls.gradesubmission.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Subject cannot be blank")
    @NonNull
    @Column(nullable = false)
    private String subject;

    @NotBlank(message = "Course code cannot be blank")
    @NonNull
    @Column(nullable = false, unique = true)
    private String code;

    @NotBlank(message = "Description cannot be blank")
    @NonNull
    @Column(nullable = false)
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Grade> grades;

}
