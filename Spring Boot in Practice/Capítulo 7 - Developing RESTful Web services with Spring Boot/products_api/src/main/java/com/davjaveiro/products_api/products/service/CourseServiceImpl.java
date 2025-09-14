package com.davjaveiro.products_api.products.service;

import com.davjaveiro.products_api.products.dtos.products.CourseResponseDTO;
import com.davjaveiro.products_api.products.dtos.products.CourseResponseDTO;
import com.davjaveiro.products_api.products.mapper.CourseMapper;
import com.davjaveiro.products_api.shared.exception.CourseNotFoundException;
import com.davjaveiro.products_api.products.domain.Course;
import com.davjaveiro.products_api.products.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private RedisTemplate<UUID, Object> redisTemplate;

    private final String REDIS_KEY = "Course";

    @Override
    public CourseResponseDTO createCourse(CourseRequestDTO courseRequestDTO) {
        Course courseEnity = courseMapper.ToEntity(courseRequestDTO);
        Course savedEntity = courseRepository.save(courseEnity);

        redisTemplate.opsForHash().put(UUID.fromString(REDIS_KEY), savedEntity.getId(), savedEntity);

        return courseMapper.toResponseDTO(savedEntity);
    }

    @Override
    public CourseResponseDTO getCourseById(long courseId) {
        // Tenta buscar no Redis primeiro
        Course cachedCourse = (Course) redisTemplate.opsForHash().get(UUID.fromString(REDIS_KEY), courseId);
        if (cachedCourse != null) {
            return courseMapper.toResponseDTO(cachedCourse);
        }

        // Se não estiver no Redis, busca no PostgreSQL
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new CourseNotFoundException(String.format("Course %s not found", courseId)));

        // Coloca no Redis para próximas consultas
        redisTemplate.opsForHash().put(UUID.fromString(REDIS_KEY), course.getId(), course);

        return courseMapper.toResponseDTO(course);
    }

    @Override
    public List<CourseResponseDTO> getCoursesByCategory(String category) {
        return courseRepository.findAllByCategory(category).stream()
                .map(courseMapper::toResponseDTO) // Converte cada item da lista
                .collect(Collectors.toList());
    }


    @Override
    public List<CourseResponseDTO> getCourses() {
        return courseRepository.findAll()
                .stream()
                .map(courseMapper::toResponseDTO)
                .toList(); // Java 16+ (antes usaria Collectors.toList())
    }

    @Override
    public Optional<CourseResponseDTO> updateCourse(Long courseId, CourseRequestDTO courseRequestDTO) {
        return  courseRepository.findById(courseId)
                .map(existingCourse -> {
                    existingCourse.setName(courseRequestDTO.name());
                    existingCourse.setDescription(courseRequestDTO.description());
                    existingCourse.setCategory(courseRequestDTO.category());

                    Course savedCourse = courseRepository.save(existingCourse);
                    redisTemplate.opsForHash().put(UUID.fromString(REDIS_KEY), savedCourse.getId(), savedCourse);
                    return courseMapper.toResponseDTO(savedCourse);
                });
    }


@Override
public void deleteCourseById(long courseId) {
    courseRepository.findById(courseId).orElseThrow(() -> new CourseNotFoundException(String.format("Course with %d not deleted because not found!", courseId)));
    courseRepository.deleteById(courseId);

    redisTemplate.opsForHash().delete(UUID.fromString(REDIS_KEY), courseId);
}

@Override
public void deleteCourses() {
    courseRepository.deleteAll();

    redisTemplate.opsForHash().delete(UUID.fromString(REDIS_KEY));
}

}

