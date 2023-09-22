package com.jrinehuls.gradesubmission.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;
import java.util.Set;

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

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "course_student",
            joinColumns = {@JoinColumn(name ="course_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name ="student_id", referencedColumnName = "id")}
    )
    private Set<Student> students;

}
