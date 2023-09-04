package com.jrinehuls.gradesubmission.exception;

import org.springframework.http.HttpStatus;

public class GradeNotFoundException extends RuntimeException {

    public GradeNotFoundException(Long id) {
        super("Grade with id '" + id + ", not found.");
    }

    public HttpStatus getStatusCode() {
        return HttpStatus.NOT_FOUND;
    }
}
