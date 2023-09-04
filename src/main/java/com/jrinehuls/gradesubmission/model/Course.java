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

    @NonNull
    @NotBlank(message = "Subject cannot be blank")
    @Column(nullable = false)
    private String subject;

    @NonNull
    @NotBlank(message = "Course code cannot be blank")
    @Column(nullable = false, unique = true)
    private String code;

    @NonNull
    @NotBlank(message = "Description cannot be blank")
    @Column(nullable = false)
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Grade> grades;


}
