package com.davjaveiro.products_api.service;

import com.davjaveiro.products_api.model.Course;

import java.util.Optional;

public interface CourseService {
    Course createCourse(Course course);

    Optional<Course> getCourseById(long courseId);

    Iterable<Course> getCoursesByCategory(String category);

    Iterable<Course> getCourses();

    Course updateCourse(Long courseId, Course course);

    void deleteCourseById(long courseId);

    void deleteCourses();
}
