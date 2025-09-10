package com.davjaveiro.products_api.controller;

import com.davjaveiro.products_api.model.Course;
import com.davjaveiro.products_api.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/courses/")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public Iterable<Course> getAllCourses() {
        return courseService.getCourses();
    }

    @GetMapping("{id}")
    public Optional<Course> getCourseById(@PathVariable("id") long id) {
        return courseService.getCourseById(id);
    }

    @GetMapping("category/{name}")
    public Iterable<Course> getCourseByCategory(@PathVariable String name) {
        return courseService.getCoursesByCategory(name);
    }

    @PostMapping
    public ResponseEntity<Course> createCourse(@Valid @RequestBody Course course) {
        Course savedCourse = courseService.createCourse(course);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCourse);
    }

    @PutMapping("{id}")
    public void updateCourse(@PathVariable long id, @RequestBody Course course) {
        courseService.updateCourse(id, course);
    }

    @DeleteMapping("{id}")
    void deleteCourseById(@PathVariable("id") long id) {
        courseService.deleteCourseById(id);
    }

    @DeleteMapping
    void deleteCourses() {
        courseService.deleteCourses();
    }
}
