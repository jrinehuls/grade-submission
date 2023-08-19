package com.jrinehuls.gradesubmission.exception;

import org.springframework.http.HttpStatus;

public class StudentNotFoundException extends RuntimeException {


    public StudentNotFoundException(Long id) {
        super("Student with id '" + id + "' not found.");
    }

    public HttpStatus getStatusCode() {
        return HttpStatus.NOT_FOUND;
    }

}
