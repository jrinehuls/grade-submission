package com.jrinehuls.gradesubmission.exception;

public class GradeNotFoundException extends ResourceNotFoundException {

    public GradeNotFoundException(Long studentId, Long courseId) {
        super(String.format("Grade not found for student with id of %d and course with id of %d.", studentId, courseId));
    }

}
