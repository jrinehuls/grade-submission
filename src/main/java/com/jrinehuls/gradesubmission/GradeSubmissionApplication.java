package com.jrinehuls.gradesubmission;

import com.jrinehuls.gradesubmission.model.Course;
import com.jrinehuls.gradesubmission.model.Student;
import com.jrinehuls.gradesubmission.repository.CourseRepository;
import com.jrinehuls.gradesubmission.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.concurrent.Callable;

@SpringBootApplication
public class GradeSubmissionApplication implements CommandLineRunner {

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	CourseRepository courseRepository;

	public static void main(String[] args) {
		SpringApplication.run(GradeSubmissionApplication.class, args);
	}


	// Get rid of this. Just used to populate some students on launch.
	@Override
	public void run(String... args) throws Exception {
		Student[] students = {
				new Student("Justin Rinehuls", LocalDate.parse("1985-03-05")),
				new Student("Jennifer Getz", LocalDate.parse("1984-07-01")),
				new Student("Yuichi Kun", LocalDate.parse("2015-09-21")),
				new Student("Patty Chan", LocalDate.parse("2019-11-11"))
		};

		for (Student student: students) {
			studentRepository.save(student);
		}

		Course[] courses = {
				new Course("Math", "104", "Calculus I"),
				new Course("Comp Sci", "107", "Programming in Java"),
				new Course("Eng", "305", "Technical Writing"),
				new Course("Comm", "101", "Public Speaking"),
				new Course("Math", "106", "Statistics"),
		};

		for (Course course: courses) {
			courseRepository.save(course);
		}
	}
}
