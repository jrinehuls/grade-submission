package com.jrinehuls.gradesubmission.exception.conflict;

public class CourseCollisionException extends ResourceCollisionException {

    public CourseCollisionException(String code) {
        super(String.format("Course already exists with course code of %s.", code));
    }
}
