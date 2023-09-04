package com.jrinehuls.gradesubmission.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;

public class ScoreValidator implements ConstraintValidator<Score, String > {

    final List<String> scores = Arrays.asList(
            "A+", "A", "A-",
            "B+", "B", "B-",
            "C+", "C", "C-",
            "D+", "D", "D-",
            "F"
    );

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        for (String score : scores) {
            if (value.equals(score)) return true;
        }
        return false;
    }

    // Didn't do anything to this method. Probably not even needed, but here in case.
    @Override
    public void initialize(Score constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

}
