package com.jrinehuls.gradesubmission;

import com.jrinehuls.gradesubmission.model.Student;
import com.jrinehuls.gradesubmission.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class GradeSubmissionApplication implements CommandLineRunner {

	@Autowired
	StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(GradeSubmissionApplication.class, args);
	}


	// Get rid of this. Just used to populate some students on launch.
	@Override
	public void run(String... args) throws Exception {
		Student[] students = {
				new Student(1L, "Justin Rinehuls", LocalDate.parse("1985-03-05")),
				new Student(2L, "Jennifer Getz", LocalDate.parse("1984-07-01")),
				new Student(3L, "Yuichi Kun", LocalDate.parse("2015-09-21")),
				new Student(4L, "Patty Chan", LocalDate.parse("2019-11-11"))
		};

		for (Student student: students) {
			studentRepository.save(student);
		}
	}
}
