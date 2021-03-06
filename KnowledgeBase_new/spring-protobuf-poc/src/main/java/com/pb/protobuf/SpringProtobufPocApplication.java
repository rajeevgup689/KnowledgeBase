package com.pb.protobuf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.pb.protobuf.repository.CourseRepository;
import com.pb.protobuf.student.StudentProtobuf.Course;
import com.pb.protobuf.student.StudentProtobuf.Student;
import com.pb.protobuf.student.StudentProtobuf.Student.PhoneNumber;
import com.pb.protobuf.student.StudentProtobuf.Student.PhoneType;

@SpringBootApplication
public class SpringProtobufPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringProtobufPocApplication.class, args);
	}

	@Bean
	RestTemplate restTemplate(ProtobufHttpMessageConverter hmc) {
		return new RestTemplate(Arrays.asList(hmc));
	}

	@Bean
	ProtobufHttpMessageConverter protobufHttpMessageConverter() {
		return new ProtobufHttpMessageConverter();
	}

	@Bean
	public CourseRepository createTestCourses() {
		Map<Integer, Course> courseMap = new HashMap<>();

		Course course1 = Course.newBuilder().setId(1).setCourseName("REST with Spring")
				.addAllStudent(createTestStudents()).putStudentMap(1, createStudent(1, "John", "Doe",
						"john.doe@baeldung.com", Arrays.asList(createPhone("123456", PhoneType.MOBILE))))
				.build();

		Course course2 = Course.newBuilder().setId(2).setCourseName("Learn Spring Security")
				.addAllStudent(new ArrayList<>()).putStudentMap(2, Student.newBuilder().build()).build();

		Student student = createStudent(4, "Rajeev", "Gupta", "rajeev.gupta@pb.com",
				Arrays.asList(createPhone("23456789", PhoneType.MOBILE)));
		Course course3 = Course.newBuilder().setId(3).setCourseName("Spring Boot with protocol buffer")
				.addAllStudent(Arrays.asList(student)).putStudentMap(3, student).build();

		courseMap.put(course1.getId(), course1);
		courseMap.put(course2.getId(), course2);
		courseMap.put(course3.getId(), course3);

		return new CourseRepository(courseMap);
	}

	private List<Student> createTestStudents() {
		PhoneNumber phone1 = createPhone("123456", PhoneType.MOBILE);
		Student student1 = createStudent(1, "John", "Doe", "john.doe@baeldung.com", Arrays.asList(phone1));

		PhoneNumber phone2 = createPhone("234567", PhoneType.LANDLINE);
		Student student2 = createStudent(2, "Richard", "Roe", "richard.roe@baeldung.com", Arrays.asList(phone2));

		PhoneNumber phone3_1 = createPhone("345678", PhoneType.MOBILE);
		PhoneNumber phone3_2 = createPhone("456789", PhoneType.LANDLINE);
		Student student3 = createStudent(3, "Jane", "Doe", "jane.doe@baeldung.com", Arrays.asList(phone3_1, phone3_2));

		return Arrays.asList(student1, student2, student3);
	}

	private Student createStudent(int id, String firstName, String lastName, String email, List<PhoneNumber> phones) {
		return Student.newBuilder().setId(id).setFirstName(firstName).setLastName(lastName).setEmail(email)
				.addAllPhone(phones).build();
	}

	private PhoneNumber createPhone(String number, PhoneType type) {
		return PhoneNumber.newBuilder().setNumber(number).setType(type).build();
	}
}
