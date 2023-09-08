package com.jrinehuls.gradesubmission.exception;

public class CourseNotFoundException extends ResourceNotFoundException {

    public CourseNotFoundException(Long id) {
        super("Course with id '" + id + "' not found.");
    }

}
