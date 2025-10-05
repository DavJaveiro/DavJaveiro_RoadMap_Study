package com.packt.courseapi.controller;

import com.packt.courseapi.domain.Course;
import com.packt.courseapi.repository.CourseJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/simpleCourses/")
public class SimpleCourseController {

    @Autowired
    private CourseJpaRepository courseJpaRepository;

    @GetMapping
    public Iterable<Course> getAllCourses(@AuthenticationPrincipal Jwt jwt) {
        String author = jwt.getClaim("author");
        return courseJpaRepository.findAllByAuthor(author);
    }

    @GetMapping("{id}")
    public Optional<Course> getCourseById(@PathVariable("id") long courseId) {
        return courseJpaRepository.findById(courseId);
    }

    @PostMapping
    public Course createCourse(@RequestBody String name, @AuthenticationPrincipal Jwt jwt, String category)
    {
        Course course = Course.builder()
                .name(name)
                .author(jwt.getClaimAsString("user_name"))
                .category(category).build();
        return courseJpaRepository.save(course);
    }

}
