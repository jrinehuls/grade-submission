package com.jrinehuls.gradesubmission.exception.notfound;

public class StudentNotEnrolledException extends ResourceNotFoundException {

    public StudentNotEnrolledException(Long studentId, Long courseId) {
        super(String.format("Student with id of %d not found in course with id of %d.", studentId, courseId));
    }
}
