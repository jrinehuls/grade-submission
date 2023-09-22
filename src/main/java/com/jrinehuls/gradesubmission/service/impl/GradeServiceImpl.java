package com.jrinehuls.gradesubmission.service.impl;

import java.util.List;

import com.jrinehuls.gradesubmission.exception.conflict.GradeCollisionException;
import com.jrinehuls.gradesubmission.exception.notfound.GradeNotFoundException;
import com.jrinehuls.gradesubmission.exception.notfound.StudentNotEnrolledException;
import com.jrinehuls.gradesubmission.model.Course;
import com.jrinehuls.gradesubmission.model.Grade;
import com.jrinehuls.gradesubmission.model.Student;
import com.jrinehuls.gradesubmission.repository.GradeRepository;
import com.jrinehuls.gradesubmission.service.CourseService;
import com.jrinehuls.gradesubmission.service.GradeService;
import com.jrinehuls.gradesubmission.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class GradeServiceImpl implements GradeService {

    GradeRepository gradeRepository;
    StudentService studentService;
    CourseService courseService;
    
    @Override
    public Grade getGrade(Long studentId, Long courseId) {
        return gradeRepository.findByStudentIdAndCourseId(studentId, courseId)
                .orElseThrow(() -> new GradeNotFoundException(studentId, courseId));
    }

    @Override
    public Grade saveGrade(Grade grade, Long studentId, Long courseId) {
        Student student = studentService.getStudent(studentId); // In 185, he called studentRepository
        Course course = courseService.getCourse(courseId);
        if (!course.getStudents().contains(student)) {
            throw new StudentNotEnrolledException(studentId, courseId);
        }
        grade.setStudent(student);
        grade.setCourse(course);
        try {
            return gradeRepository.save(grade);
        } catch (DataIntegrityViolationException e) {
            throw new GradeCollisionException(studentId, courseId);
        }
    }

    @Override
    public Grade updateGrade(String score, Long studentId, Long courseId) {
        Grade grade = gradeRepository.findByStudentIdAndCourseId(studentId, courseId)
                .orElseThrow(() -> new GradeNotFoundException(studentId, courseId));
        grade.setScore(score);
        return gradeRepository.save(grade);
    }

    @Override
    public void deleteGrade(Long studentId, Long courseId) {
        Grade grade = gradeRepository.findByStudentIdAndCourseId(studentId, courseId)
                .orElseThrow(() -> new GradeNotFoundException(studentId, courseId));
        System.out.println(grade.getId());
        gradeRepository.deleteById(grade.getId());
    }

    @Override
    public List<Grade> getStudentGrades(Long studentId) {
        return gradeRepository.findByStudentId(studentId);
    }

    @Override
    public List<Grade> getCourseGrades(Long courseId) {
        return gradeRepository.findByCourseId(courseId);
    }

    @Override
    public List<Grade> getAllGrades() {
        return (List<Grade>) gradeRepository.findAll();
    }

}
