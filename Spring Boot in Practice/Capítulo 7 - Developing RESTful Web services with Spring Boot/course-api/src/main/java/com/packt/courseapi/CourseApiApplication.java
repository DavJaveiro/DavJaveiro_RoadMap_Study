package com.packt.courseapi;

import com.packt.courseapi.domain.Course;
import com.packt.courseapi.repository.CourseJpaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CourseApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseApiApplication.class, args);
	}



	@Bean
	CommandLineRunner createCurse(CourseJpaRepository courseJpaRepository) {
		return args -> {
			Course spring = Course.builder()
					.name("Spring Boot in Practice")
					.category("Spring Boot")
					.author("John")
					.build();

			Course python = Course.builder()
					.name("Python in Practice")
					.category("Python")
					.author("Steve")
					.build();
		};
	}
}
