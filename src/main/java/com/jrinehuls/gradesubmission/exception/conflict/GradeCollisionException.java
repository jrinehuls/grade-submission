package com.jrinehuls.gradesubmission.exception.conflict;

public class GradeCollisionException extends ResourceCollisionException {

    public GradeCollisionException(Long studentId, Long courseId) {
        super(String.format("Grade already exists for student with id of %d in course with id of %d.", studentId, courseId));
    }
}
