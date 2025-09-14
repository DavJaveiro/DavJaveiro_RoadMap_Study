package com.davjaveiro.products_api.products.mapper;

import com.davjaveiro.products_api.products.domain.Course;
import com.davjaveiro.products_api.products.dtos.products.CourseRequestDTO;
import com.davjaveiro.products_api.products.dtos.products.CourseResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {

    // DTO para entidade
    public Course ToEntity(CourseRequestDTO courseRequestDTO) {
        // 1. Criamos um objeto Course (Entidade) vazio
        Course course = new Course();

        // 2. Copiamos os dados fornecidos pelo DTO para a entidade;
        course.setName(courseRequestDTO.name());
        course.setCategory(courseRequestDTO.category());
        course.setDescription(courseRequestDTO.description());
        return course;
    }

    // Entidade para DTO
    public CourseResponseDTO toResponseDTO(Course entity) {
        return new CourseResponseDTO(entity.getId(), entity.getName(), entity.getCategory(), entity.getDescription());
    }
}
