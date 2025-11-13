package com.packt.courseapi.service;

import com.packt.courseapi.domain.Course;
import com.packt.courseapi.dtos.CourseRequestDTO;
import com.packt.courseapi.dtos.CourseResponseDTO;
import com.packt.courseapi.mapper.CourseMapper;
import com.packt.courseapi.repository.CourseRepsitory;
import com.packt.courseapi.shared.exception.CourseNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepsitory courseRepsitory;

    @Autowired
    private CourseMapper courseMapper;


    @Override
    public CourseResponseDTO createCourse(CourseRequestDTO courseRequestDTO) {
        Course courseEnity = courseMapper.ToEntity(courseRequestDTO);
        Course savedEntity = courseRepsitory.save(courseEnity);

        return courseMapper.toResponseDTO(savedEntity);
    }

    @Override
    public CourseResponseDTO getCourseById(long courseId) {
        System.out.println("Buscando no banco de dados o cursoId: " + courseId);
        Course course = courseRepsitory.findById(courseId).orElseThrow(() -> new CourseNotFoundException(String.format("Course with ID %d not found", courseId)));

        return courseMapper.toResponseDTO(course);
    }

    @Override
    public List<CourseResponseDTO> getCoursesByCategory(String category) {
        return courseRepsitory.findAllByCategory(category).stream().map(courseMapper::toResponseDTO) // Converte cada item da lista
                .collect(Collectors.toList());
    }


    @Override
    public List<CourseResponseDTO> getCourses() {
        return courseRepsitory.findAll().stream().map(courseMapper::toResponseDTO).toList(); // Java 16+ (antes usaria Collectors.toList())
    }

    @Override
    public Optional<CourseResponseDTO> updateCourse(Long courseId, CourseRequestDTO courseRequestDTO) {
        return courseRepsitory.findById(courseId).map(existingCourse -> {
            existingCourse.setName(courseRequestDTO.name());
            existingCourse.setDescription(courseRequestDTO.description());
            existingCourse.setCategory(courseRequestDTO.category());

            Course savedCourse = courseRepsitory.save(existingCourse);
            return courseMapper.toResponseDTO(savedCourse);
        });
    }


    @Override
    public void deleteCourseById(long courseId) {
        courseRepsitory.findById(courseId).orElseThrow(() -> new CourseNotFoundException(String.format("Course with %d not deleted because not found!", courseId)));
        courseRepsitory.deleteById(courseId);

    }

    @Override
    public void deleteCourses() {
        courseRepsitory.deleteAll();
    }

}