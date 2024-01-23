package com.ikzProj.StudentManagement;

import com.ikzProj.StudentManagement.entity.Gender;
import com.ikzProj.StudentManagement.entity.Student;
import com.ikzProj.StudentManagement.entity.Teacher;
import com.ikzProj.StudentManagement.entity.User;
import com.ikzProj.StudentManagement.repository.StudentRepository;
import com.ikzProj.StudentManagement.repository.TeacherRepository;
import com.ikzProj.StudentManagement.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static java.time.LocalDate.of;

@SpringBootApplication
public class StudentManagementApplication implements CommandLineRunner {
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private TeacherRepository teacherRepository;
	@Autowired
	private UserRepository userRepository;
	private static final Logger logger = LoggerFactory.getLogger(StudentManagementApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(StudentManagementApplication.class, args);

		logger.info("Application Started>>");
	}

	@Override
	public void run(String... args) throws Exception {

		Teacher teacher1 = new Teacher("Ajmal","Hakim");
		Teacher teacher2 = new Teacher("Danny","Chao");
		teacherRepository.saveAll(Arrays.asList(teacher1,teacher2));



		List<Student> students= Arrays.asList(
                new Student("John", "Doe", Gender.Male, "Computer Science", "doe@doe.", of(2019, 6,1), LocalDate.now()),
        new Student("Sam", "Kampala", Gender.Male, "Data Science", "sam@sam.com",  LocalDate.of(2018,8,1),  LocalDate.of(2022,1,20))
        );
		studentRepository.saveAll(students);
		studentRepository.findAll().forEach(student -> logger.info(student.getFirstName()+" "+ student.getLastName()));

		teacherRepository.findAll().forEach(teacher -> logger.info(teacher.getFirstName()));

		userRepository.save(new User("admin","$2y$10$vWRjQTW0TI9RIOPR2kp8EuT8JAp2CKaAZq2oiOuS9f4PrE6orOvgO","ADMIN"));
		userRepository.save(new User("user","$2y$10$vG9HygzUW.vakuwzmHjM8Otr3TTlssfFhkFnHn67RTzugMy8kv6U6","USER"));



	}
}
