package com.jrinehuls.gradesubmission.controller;

import com.jrinehuls.gradesubmission.model.Course;
import com.jrinehuls.gradesubmission.model.Student;
import com.jrinehuls.gradesubmission.service.CourseService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;


@AllArgsConstructor
@RestController
@RequestMapping("/course")
public class CourseController {

    CourseService courseService;

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourse(@PathVariable Long id) {
        return new ResponseEntity<>(courseService.getCourse(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Course> saveCourse(@Valid @RequestBody Course course) {
        return new ResponseEntity<>(courseService.saveCourse(course), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Course>> getCourses() {
        return new ResponseEntity<>(courseService.getCourses(), HttpStatus.OK);
    }

    @PutMapping("/{courseId}/student/{studentId}")
    public ResponseEntity<Course> enrollStudentInCourse(@PathVariable Long courseId, @PathVariable Long studentId) {
        Course course = courseService.enrollStudentInCourse(courseId, studentId);
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @GetMapping("/{courseId}/students")
    public ResponseEntity<Set<Student>> getEnrolledStudents(@PathVariable Long courseId) {
        Set<Student> students = courseService.getEnrolledStudents(courseId);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

}