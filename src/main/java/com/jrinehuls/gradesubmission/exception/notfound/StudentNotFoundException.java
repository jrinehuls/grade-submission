package com.jrinehuls.gradesubmission.exception.notfound;

public class StudentNotFoundException extends ResourceNotFoundException {

    public StudentNotFoundException(Long id) {
        super("Student with id '" + id + "' not found.");
    }

}
