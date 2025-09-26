package com.packt.courseapi.mapper;

import com.packt.courseapi.domain.Course;
import com.packt.courseapi.dtos.CourseRequestDTO;
import com.packt.courseapi.dtos.CourseResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {

    // DTO para entidade
    public Course ToEntity(CourseRequestDTO courseRequestDTO) {
        Course course = new Course();

        // 2. Copiamos os dados fornecidos pelo DTO par a entidade
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
