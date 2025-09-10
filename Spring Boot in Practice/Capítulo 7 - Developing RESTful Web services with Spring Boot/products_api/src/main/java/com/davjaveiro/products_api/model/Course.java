package com.davjaveiro.products_api.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table(name = "COURSES")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;


    @Column(name = "NAME")
    @NotBlank(message = "O nome não pode ser em branco!")
    private String name;

    @Column(name = "CATEGORY")
    @NotBlank(message = "A categoria não pode ficar em branca.")
    private String category;

    @Column(name = "RATING")
    private int rating;

    @Column(name = "DESCRIPTION")
    private String description;
}
