package com.jrinehuls.gradesubmission.exception;

import org.springframework.http.HttpStatus;

public class GradeNotFoundException extends RuntimeException {

    public GradeNotFoundException(Long studentId, Long courseId) {
        super(String.format("Grade not found for student with id of %d and course with id of %d.", studentId, courseId));
    }

    public HttpStatus getStatusCode() {
        return HttpStatus.NOT_FOUND;
    }
}
