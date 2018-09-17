package com.pb.protobuf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pb.protobuf.repository.CourseRepository;
import com.pb.protobuf.student.StudentProtobuf.Course;

@RestController
public class CourseController {

	@Autowired
	CourseRepository courseRepo;

	@RequestMapping("/courses/{id}")
	Course studentCourse(@PathVariable Integer id) {
		return courseRepo.getCourse(id);
	}
}
