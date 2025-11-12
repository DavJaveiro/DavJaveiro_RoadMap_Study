package com.davjaveiro.products_api;

// Imports necessários do Spring

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ProductsApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductsApiApplication.class, args);
    }

}