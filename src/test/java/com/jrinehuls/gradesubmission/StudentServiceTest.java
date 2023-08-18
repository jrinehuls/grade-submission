package com.jrinehuls.gradesubmission;

import com.jrinehuls.gradesubmission.model.Student;
import com.jrinehuls.gradesubmission.repository.StudentRepository;
import com.jrinehuls.gradesubmission.service.StudentService;
import com.jrinehuls.gradesubmission.service.StudentServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.time.Month;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentServiceImpl studentService;

    @Test
    public void testGetStudent() {
        Student repoStudent = new Student(1L, "Justin", LocalDate.of(1985, Month.MARCH, 5));
        when(studentRepository.findById(1L)).thenReturn(Optional.of(repoStudent));
        Student student = studentService.getStudent(1L);
        Assertions.assertEquals(repoStudent.getBirthDate().getMonth().getValue(), student.getBirthDate().getMonthValue());
    }
}
