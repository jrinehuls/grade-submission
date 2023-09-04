package com.jrinehuls.gradesubmission.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "student")
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size.List({
            @Size(min = 10, message = "Name must contain at least 10 characters"),
            @Size(max = 50, message = "Name must not exceed 50 characters")
    })
    @NonNull // Lombok to make it a required arg
    @NotBlank(message = "Name cannot be blank")
    @Column(name = "name", nullable = false)
    private String name;

    @NonNull // Lombok to make it a required arg
    @Past(message = "Birth date must be in the past.")
    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @JsonIgnore // If not here, would call grades, which calls student, which calls grades, which calls student
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL) // student because it's the variable name of the FK in the child table
    private List<Grade> grades;

}
