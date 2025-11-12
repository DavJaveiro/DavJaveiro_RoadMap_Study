package com.davjaveiro.products_api.products.service;

import com.davjaveiro.products_api.products.domain.Course;
import com.davjaveiro.products_api.products.dtos.products.CourseRequestDTO;
import com.davjaveiro.products_api.products.dtos.products.CourseResponseDTO;
import com.davjaveiro.products_api.products.mapper.CourseMapper;
import com.davjaveiro.products_api.products.repository.CourseJpaRepository;
import com.davjaveiro.products_api.shared.exception.CourseNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseJpaRepository courseJpaRepository;

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private RedisTemplate<UUID, Object> redisTemplate;

    private final String REDIS_KEY = "Course";

    @Override
    public CourseResponseDTO createCourse(CourseRequestDTO courseRequestDTO) {
        Course courseEnity = courseMapper.ToEntity(courseRequestDTO);
        Course savedEntity = courseJpaRepository.save(courseEnity);

        redisTemplate.opsForHash().put(UUID.fromString(REDIS_KEY), savedEntity.getId(), savedEntity);

        return courseMapper.toResponseDTO(savedEntity);
    }

    @Override
    public CourseResponseDTO getCourseById(long courseId) {
        System.out.println("Buscando no banco de dados o cursoId: " + courseId);
        Course course = courseJpaRepository.findById(courseId).orElseThrow(() -> new CourseNotFoundException(String.format("Course with ID %d not found", courseId)));

        return courseMapper.toResponseDTO(course);
    }

    @Override
    public List<CourseResponseDTO> getCoursesByCategory(String category) {
        return courseJpaRepository.findAllByCategory(category).stream().map(courseMapper::toResponseDTO) // Converte cada item da lista
                .collect(Collectors.toList());
    }


    @Override
    public List<CourseResponseDTO> getCourses() {
        return courseJpaRepository.findAll().stream().map(courseMapper::toResponseDTO).toList(); // Java 16+ (antes usaria Collectors.toList())
    }

    @Override
    public Optional<CourseResponseDTO> updateCourse(Long courseId, CourseRequestDTO courseRequestDTO) {
        return courseJpaRepository.findById(courseId).map(existingCourse -> {
            existingCourse.setName(courseRequestDTO.name());
            existingCourse.setDescription(courseRequestDTO.description());
            existingCourse.setCategory(courseRequestDTO.category());

            Course savedCourse = courseJpaRepository.save(existingCourse);
            redisTemplate.opsForHash().put(UUID.fromString(REDIS_KEY), savedCourse.getId(), savedCourse);
            return courseMapper.toResponseDTO(savedCourse);
        });
    }


    @Override
    public void deleteCourseById(long courseId) {
        courseJpaRepository.findById(courseId).orElseThrow(() -> new CourseNotFoundException(String.format("Course with %d not deleted because not found!", courseId)));
        courseJpaRepository.deleteById(courseId);

        redisTemplate.opsForHash().delete(UUID.fromString(REDIS_KEY), courseId);
    }

    @Override
    public void deleteCourses() {
        courseJpaRepository.deleteAll();

        redisTemplate.opsForHash().delete(UUID.fromString(REDIS_KEY));
    }

}

