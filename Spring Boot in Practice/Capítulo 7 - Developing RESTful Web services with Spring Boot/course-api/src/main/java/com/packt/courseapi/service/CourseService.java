package com.packt.courseapi.service;

import com.packt.courseapi.dtos.CourseRequestDTO;
import com.packt.courseapi.dtos.CourseResponseDTO;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    CourseResponseDTO createCourse(CourseRequestDTO courseDTO);

    CourseResponseDTO getCourseById(long courseId);

    List<CourseResponseDTO> getCoursesByCategory(String category);

    List<CourseResponseDTO> getCourses();


    Optional<CourseResponseDTO> updateCourse(Long courseId, CourseRequestDTO courseDTO);

    void deleteCourseById(long courseId);

    void deleteCourses();
}
