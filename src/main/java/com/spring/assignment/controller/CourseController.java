package com.spring.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.assignment.dto.MessageDto;
import com.spring.assignment.exception.InvalidIDException;
import com.spring.assignment.model.Course;
import com.spring.assignment.service.CourseService;

@RestController
public class CourseController {

	@Autowired
	CourseService courseService;

	@Autowired
	MessageDto messageDto;

	@PostMapping("/api/course/add")
	public Course addCourse(@RequestBody Course course) {
		return courseService.addCourse(course);
	}

	@GetMapping("/api/course/one/{id}")
	public ResponseEntity<?> getOneCourse(@PathVariable int id) {
		try {
			Course course = courseService.getOneCourse(id);
			return ResponseEntity.ok(course);
		} catch (InvalidIDException e) {
			messageDto.setBody(e.getMessage());
			messageDto.setStatusCode(400);
			return ResponseEntity.status(400).body(messageDto);

		}
	}

	@GetMapping("/api/course/getall")
	public List<Course> getAllCourse() {
		return courseService.getAllCourse();
	}

	@DeleteMapping("/api/course/delete/{id}")
	public ResponseEntity<?> deleteById(@PathVariable int id) {
		try {
			Course course = courseService.getOneCourse(id);
			courseService.deleteById(course);
			messageDto.setBody("Course deleted successfully!!!");
			messageDto.setStatusCode(200);
			return ResponseEntity.ok(messageDto);
		} catch (InvalidIDException e) {
			messageDto.setBody(e.getMessage());
			messageDto.setStatusCode(400);
			return ResponseEntity.status(400).body(messageDto);
		}
	}

	@PutMapping("/api/course/update")
	public ResponseEntity<?> updateCourse(@RequestBody Course newValue, @RequestParam int id) {
		try {
			Course course = courseService.getOneCourse(id);
			if (newValue.getTitle() != null)
				course.setTitle(newValue.getTitle());
			if (newValue.getCredits() != 0)
				course.setCredits(newValue.getCredits());
			if (newValue.getFee() != 0)
				course.setFee(newValue.getFee());

			messageDto.setBody("updated successfully!!!");
			messageDto.setStatusCode(200);
			return ResponseEntity.ok(messageDto);
		} catch (InvalidIDException e) {

			messageDto.setBody(e.getMessage());
			messageDto.setStatusCode(400);
			return ResponseEntity.status(400).body(messageDto);

		}
	}
}
