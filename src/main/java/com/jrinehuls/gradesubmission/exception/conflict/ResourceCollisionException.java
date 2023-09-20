package com.jrinehuls.gradesubmission.exception.conflict;

import org.springframework.http.HttpStatus;

public abstract class ResourceCollisionException extends RuntimeException {

    public ResourceCollisionException(String message) {
            super(message);
    }

    public HttpStatus getStatusCode() {
        return HttpStatus.CONFLICT;
    }

}
