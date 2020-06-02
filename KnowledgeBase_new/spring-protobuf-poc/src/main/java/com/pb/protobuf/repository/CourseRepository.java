package com.pb.protobuf.repository;

import java.util.Map;

import com.pb.protobuf.student.StudentProtobuf.Course;

public class CourseRepository {

	private Map<Integer, Course> courseMap;
	
	public CourseRepository(Map<Integer, Course> courseMap) {
		super();
		this.courseMap = courseMap;
	}

	public Course getCourse(Integer id) {
		if(courseMap.containsKey(id)) {
			return courseMap.get(id);
		}
		
		return null;
	}

}
