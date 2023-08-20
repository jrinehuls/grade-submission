package com.jrinehuls.gradesubmission;

import com.jrinehuls.gradesubmission.model.Student;
import com.jrinehuls.gradesubmission.repository.StudentRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.time.Month;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
class GradeSubmissionApplicationTests {

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	MockMvc mockMvc;

	Student[] students = {
			new Student("Justin", LocalDate.of(1985, Month.MARCH, 5)),
			new Student("Jen", LocalDate.of(1984, Month.JULY, 1))
	};

	@BeforeEach
	void setup() {
		for (Student student : students) {
			studentRepository.save(student);
		}
	}

	@AfterEach
	void clear() {
		studentRepository.deleteAll();
	}

	@Test
	void testGetStudent() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.get("/student/1")
				.contentType(MediaType.APPLICATION_JSON);
		mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.name").value(students[0].getName()));
	}



	/*
	@Test
	void contextLoads() {
	}
	*/

}
