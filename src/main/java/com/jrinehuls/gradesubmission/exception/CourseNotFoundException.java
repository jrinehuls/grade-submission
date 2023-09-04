package com.jrinehuls.gradesubmission.exception;

import org.springframework.http.HttpStatus;

public class CourseNotFoundException extends RuntimeException {

    public CourseNotFoundException(Long id) {
        super("Course with id '" + id + "' not found.");
    }

    public HttpStatus getStatusCode() {
        return HttpStatus.NOT_FOUND;
    }
}
