package com.davjaveiro.products_api.products.repository;

import com.davjaveiro.products_api.products.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findAllByCategory(String description);
}
