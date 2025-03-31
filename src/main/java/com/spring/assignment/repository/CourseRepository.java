package com.spring.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.assignment.model.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

}
