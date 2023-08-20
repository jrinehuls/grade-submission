package com.jrinehuls.gradesubmission.repository;


import com.jrinehuls.gradesubmission.model.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Long> {

}