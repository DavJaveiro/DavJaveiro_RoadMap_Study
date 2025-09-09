package com.davjaveiro.products_api.controller;

import com.davjaveiro.products_api.model.Course;
import com.davjaveiro.products_api.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Course createCourse(@RequestBody Course course) {
        return courseService.createCourse(course);
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
