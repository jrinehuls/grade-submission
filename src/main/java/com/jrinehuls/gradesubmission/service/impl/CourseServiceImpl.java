package com.jrinehuls.gradesubmission.service.impl;

import java.util.List;

import com.jrinehuls.gradesubmission.exception.conflict.CourseCollisionException;
import com.jrinehuls.gradesubmission.exception.notfound.CourseNotFoundException;
import com.jrinehuls.gradesubmission.model.Course;
import com.jrinehuls.gradesubmission.repository.CourseRepository;
import com.jrinehuls.gradesubmission.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {

    CourseRepository courseRepository;

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

}
