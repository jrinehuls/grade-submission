package com.jrinehuls.gradesubmission.Annotations;

import com.jrinehuls.gradesubmission.model.Grade;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = GradeValidator.class)
public @interface Score {

    // TODO: Find a way to not hard code this. Message must be constant, so can't call getter.
    // maybe setting message in POJO will allow it.
    String message() default "Score must be of the following: A+, A, A-, B+, B, B-, C+, C, C-, D+, D, D- F";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
