package com.jrinehuls.gradesubmission.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "student")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    @Size.List({
            @Size(min = 10, message = "Name must not contain at least 10 characters"),
            @Size(max = 50, message = "Name must not exceed 50 characters")
    })
    private String name;

    @Column(name = "birth_date", nullable = false)
    @NotNull(message = "birthDate filed is required.")
    private LocalDate birthDate;


}
