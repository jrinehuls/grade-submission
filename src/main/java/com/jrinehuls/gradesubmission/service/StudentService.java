package com.jrinehuls.gradesubmission.service;

import java.util.List;

import com.jrinehuls.gradesubmission.entity.Student;

public interface StudentService {
    Student getStudent(Long id);
    Student saveStudent(Student student);
    void deleteStudent(Long id);
    List<Student> getStudents();
}