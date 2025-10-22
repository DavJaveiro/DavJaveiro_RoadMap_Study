package com.packt.courseapi.controller;

import com.packt.courseapi.domain.Course;
import com.packt.courseapi.repository.CourseRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.Optional;

@RestController
@RequestMapping("/simpleCourses/")
public class SimpleCourseController {

    @Autowired
    private CourseRepsitory courseRepsitory;

    @GetMapping
    public Flux<Course> getAllCourses(@AuthenticationPrincipal Jwt jwt) {
        String author = jwt.getClaim("author");
        return courseRepsitory.findAllByAuthor(author);
    }

    @GetMapping("{id}")
    public Optional<Course> getCourseById(@PathVariable("id") long courseId) {
        return courseRepsitory.findById(courseId);
    }

    @PostMapping
    public Course createCourse(@RequestBody String name, @AuthenticationPrincipal Jwt jwt, String category)
    {
        Course course = Course.builder()
                .name(name)
                .author(jwt.getClaimAsString("user_name"))
                .category(category).build();
        return courseRepsitory.save(course);
    }

}
