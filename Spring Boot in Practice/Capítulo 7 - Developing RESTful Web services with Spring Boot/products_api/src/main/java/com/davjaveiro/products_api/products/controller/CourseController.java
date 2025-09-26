package com.davjaveiro.products_api.products.controller;

import com.davjaveiro.products_api.products.dtos.products.CourseRequestDTO;
import com.davjaveiro.products_api.products.dtos.products.CourseResponseDTO;
import com.davjaveiro.products_api.products.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses/")
public class CourseController {


    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<CourseResponseDTO> getAllCourses() {
        return courseService.getCourses();
    }

    @GetMapping("{id}")
    public ResponseEntity<CourseResponseDTO> getCourseById(@PathVariable("id") long id) {
        return ResponseEntity.ok(courseService.getCourseById(id));
    }

    @GetMapping("category/{name}")
    public List<CourseResponseDTO> getCourseByCategory(@PathVariable String name) {
        return courseService.getCoursesByCategory(name);
    }

    @PostMapping
    public ResponseEntity<CourseResponseDTO> createCourse(@Valid @RequestBody CourseRequestDTO courseRequestDTO) {
        CourseResponseDTO savedCourse = courseService.createCourse(courseRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCourse);
    }

    @PutMapping("{id}")
    public void updateCourse(@PathVariable long id, @RequestBody CourseRequestDTO courseRequestDTO) {
        courseService.updateCourse(id, courseRequestDTO);
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
