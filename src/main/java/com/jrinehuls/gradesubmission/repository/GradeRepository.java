package com.jrinehuls.gradesubmission.repository;

import com.jrinehuls.gradesubmission.model.Grade;
import org.springframework.data.repository.CrudRepository;

public interface GradeRepository extends CrudRepository<Grade, Long> {
    Grade findByStudentId(Long studentId);
}