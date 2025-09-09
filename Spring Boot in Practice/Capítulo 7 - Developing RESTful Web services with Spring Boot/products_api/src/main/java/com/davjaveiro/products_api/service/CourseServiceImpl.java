package com.davjaveiro.products_api.service;

import com.davjaveiro.products_api.exception.CourseNotFoundException;
import com.davjaveiro.products_api.model.Course;
import com.davjaveiro.products_api.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Optional<Course> getCourseById(long courseId) {
        Course existCourse = courseRepository.findById(courseId)
                .orElseThrow(() -> new CourseNotFoundException(String.format("Course with id %d not found", courseId)));
        return courseRepository.findById(courseId);
    }

    @Override
    public Iterable<Course> getCoursesByCategory(String category) {
        return courseRepository.findAllByCategory(category);
    }

    @Override
    public Iterable<Course> getCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course updateCourse(Long courseId, Course course) {
        Course existCourse = courseRepository.findById(courseId)
                .orElseThrow(() -> new CourseNotFoundException(String.format("Course with %d not found", courseId)));
        existCourse.setName(course.getName());
        existCourse.setCategory(course.getCategory());
        existCourse.setDescription(course.getDescription());
        existCourse.setRating(course.getRating());

        return courseRepository.save(existCourse);
    }


@Override
public void deleteCourseById(long courseId) {
    courseRepository.findById(courseId).orElseThrow(() -> new CourseNotFoundException(String.format("Course with %d not deleted because not found!", courseId)));
    courseRepository.deleteById(courseId);
}

@Override
public void deleteCourses() {
    courseRepository.deleteAll();
}

}

