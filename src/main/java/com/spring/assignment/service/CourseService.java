package com.spring.assignment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.assignment.exception.InvalidIDException;
import com.spring.assignment.model.Course;
import com.spring.assignment.repository.CourseRepository;

@Service
public class CourseService {

	@Autowired
	CourseRepository courseRepository;

	public Course addCourse(Course course) {
		return courseRepository.save(course);
	}

	public Course getOneCourse(int id) throws InvalidIDException {
		Optional<Course> optional = courseRepository.findById(id);
		if (optional.isEmpty())
			throw new InvalidIDException("ID is Invalid!");
		return optional.get();
	}

	public List<Course> getAllCourse() {
		return courseRepository.findAll();
	}

	public void deleteById(Course course) {
		courseRepository.delete(course);

	}

}
