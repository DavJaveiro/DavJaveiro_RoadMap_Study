package com.davjaveiro.products_api;

// Imports necessários do Spring

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@SpringBootApplication
@EnableCaching // Liga o sistema de cache (@Cacheable, etc.) que discutimos

// --- ESTAS SÃO AS CORREÇÕES ---

// 1. Diz ao JPA para olhar APENAS neste pacote (onde seu CourseRepository está)
@EnableJpaRepositories(basePackages = "com.davjaveiro.products_api.products.repository")

// 2. Diz ao Redis para olhar APENAS neste pacote (que deve estar vazio ou não existir)
// Isso impede que ele escaneie o pacote do JPA e cause o conflito.
@EnableRedisRepositories(basePackages = "com.davjaveiro.products_api.products.redis_repository")
// --- FIM DAS CORREÇÕES ---

public class ProductsApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductsApiApplication.class, args);
    }

}