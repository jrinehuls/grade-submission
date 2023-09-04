package com.jrinehuls.gradesubmission.service.impl;

import java.util.List;

import com.jrinehuls.gradesubmission.exception.StudentNotFoundException;
import com.jrinehuls.gradesubmission.model.Student;
import com.jrinehuls.gradesubmission.repository.StudentRepository;
import com.jrinehuls.gradesubmission.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

    StudentRepository studentRepository;

    @Override
    public Student getStudent(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
    }

    @Override
    public List<Student> getStudents() {
        return (List<Student>) studentRepository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

}