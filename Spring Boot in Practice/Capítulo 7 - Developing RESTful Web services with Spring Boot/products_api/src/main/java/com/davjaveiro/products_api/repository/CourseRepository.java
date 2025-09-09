package com.davjaveiro.products_api.repository;

import com.davjaveiro.products_api.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Long> {
    Iterable<Course> findAllByCategory(String description);
}
