package com.jrinehuls.gradesubmission.service;

import java.util.List;

import com.jrinehuls.gradesubmission.model.Course;
import com.jrinehuls.gradesubmission.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {

    CourseRepository courseRepository;

    @Override
    public Course getCourse(Long id) {
        return null;
    }

    @Override
    public Course saveCourse(Course course) {
        return null;
    }

    @Override
    public void deleteCourse(Long id) {        
    }

    @Override
    public List<Course> getCourses() {
        return null;
    }

}
