package com.packt.courseapi.repository;

import com.packt.courseapi.domain.Course;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface CourseRepsitory extends ReactiveCrudRepository<Course, Long> {
    Flux<Course> findAllByCategory(@NotBlank(message = "A categoria não pode ficar em branca.") String category);
    Flux<Course> findAllByAuthor(String author);
}
