package com.jrinehuls.gradesubmission.service;

import java.util.List;
import java.util.Set;

import com.jrinehuls.gradesubmission.model.Course;
import com.jrinehuls.gradesubmission.model.Student;

public interface CourseService {
    Course getCourse(Long id);
    Course saveCourse(Course course);
    void deleteCourse(Long id);
    List<Course> getCourses();

    Course enrollStudentInCourse(Long courseId, Long studentId);

    Set<Student> getEnrolledStudents(Long courseId);
}