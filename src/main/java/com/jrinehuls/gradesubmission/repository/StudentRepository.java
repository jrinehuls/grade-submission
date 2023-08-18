package com.jrinehuls.gradesubmission.repository;

import com.jrinehuls.gradesubmission.model.Student;
import org.springframework.data.repository.CrudRepository;


public interface StudentRepository extends CrudRepository<Student, Long> {

}