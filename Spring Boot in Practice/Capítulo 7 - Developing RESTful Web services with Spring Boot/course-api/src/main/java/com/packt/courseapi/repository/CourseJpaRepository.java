package com.packt.courseapi.repository;

import com.packt.courseapi.domain.Course;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface CourseJpaRepository extends JpaRepository<Course, Long> {
    List<Course> findAllByCategory(@NotBlank(message = "A categoria não pode ficar em branca.") String category);
}
