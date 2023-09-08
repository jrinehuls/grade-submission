package com.jrinehuls.gradesubmission.exception;

import org.springframework.http.HttpStatus;

public abstract class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public HttpStatus getStatusCode() {
        return HttpStatus.NOT_FOUND;
    }
}
