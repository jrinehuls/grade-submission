package com.jrinehuls.gradesubmission.service.impl;

import java.util.List;
import java.util.Set;

import com.jrinehuls.gradesubmission.exception.conflict.CourseCollisionException;
import com.jrinehuls.gradesubmission.exception.notfound.CourseNotFoundException;
import com.jrinehuls.gradesubmission.model.Course;
import com.jrinehuls.gradesubmission.model.Student;
import com.jrinehuls.gradesubmission.repository.CourseRepository;
import com.jrinehuls.gradesubmission.service.CourseService;
import com.jrinehuls.gradesubmission.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@AllArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {

    CourseRepository courseRepository;
    StudentService studentService;

    @Override
    public Course getCourse(Long id) {
        return courseRepository.findById(id).orElseThrow(() -> new CourseNotFoundException(id));
    }

    @Override
    public List<Course> getCourses() {
        return (List<Course>) courseRepository.findAll();
    }

    @Override
    public Course saveCourse(Course course) {
        try {
            return courseRepository.save(course);
        } catch (DataIntegrityViolationException e) {
            throw new CourseCollisionException(course.getCode());
        }
    }

    @Override
    public void deleteCourse(Long id) {
        Course course = courseRepository.findById(id).orElseThrow(() -> new CourseNotFoundException(id));
        courseRepository.deleteById(course.getId());
    }

    @Override
    public Course enrollStudentInCourse(Long courseId, Long studentId) {
        Course course = this.getCourse(courseId);
        Student student = studentService.getStudent(studentId);
        course.getStudents().add(student);
        return courseRepository.save(course);
    }

    @Override
    public Set<Student> getEnrolledStudents(Long courseId) {
        Course course = this.getCourse(courseId);
        return course.getStudents();
    }

}
