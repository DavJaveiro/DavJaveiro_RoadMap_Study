package com.davjaveiro.products_api.products.domain;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

@Entity
@Table(name = "COURSES")
@Data
@Builder // permite construir objetos de forma fluente e legível, sem precisar lembrar a ordem dos parâmetros
@NoArgsConstructor // cria automaticamente um construtor vazio (sem argumentos)
@AllArgsConstructor // cria automaticamente um construtor com todos os atributos da classe
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
