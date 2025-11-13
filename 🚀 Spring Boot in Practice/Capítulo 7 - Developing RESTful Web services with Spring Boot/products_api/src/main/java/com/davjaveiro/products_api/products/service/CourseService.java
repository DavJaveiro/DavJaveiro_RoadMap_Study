package com.davjaveiro.products_api.products.service;

import com.davjaveiro.products_api.products.dtos.products.CourseRequestDTO;
import com.davjaveiro.products_api.products.dtos.products.CourseResponseDTO;

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
