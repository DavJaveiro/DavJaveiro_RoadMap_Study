// Renomeie a interface para CourseJpaRepository
package com.davjaveiro.products_api.products.repository;

import com.davjaveiro.products_api.products.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseJpaRepository extends JpaRepository<Course, Long> { // <-- MUDANÇA AQUI
    List<Course> findAllByCategory(String description);
}