package com.davjaveiro.products_api;

import com.davjaveiro.products_api.products.domain.Course;
import com.davjaveiro.products_api.products.service.CourseService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
class ProductsApiApplicationTests {

    @Autowired
    private CourseService courseService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testPostCourse() throws Exception {
        Course course = Course.builder()
                .name("Rapid Spring Boot Application Development")
                .category("Spring")
                .rating(5)
                .description("Rapid Spring Boot")
                .build();

        ObjectMapper objectMapper = new ObjectMapper();

        MockHttpServletResponse response = mockMvc.perform(post("/courses/")
                .contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(course)))
                .andDo(print())
                .andExpect(jsonPath("$.*", hasSize(5)))
                .andExpect(jsonPath("$.id", greaterThan(0)))
                .andExpect(jsonPath("$.name").value("Rapid Spring Boot Application Development"))
                .andExpect(jsonPath("$.category").value("Spring"))
                .andExpect(jsonPath("$.rating").value(5))
                .andExpect(status().isCreated()).andReturn().getResponse();



            Integer courseId = JsonPath.parse(response.getContentAsString()).read("$.id");
            mockMvc.perform(get("/courses/{id}", courseId))
                    .andDo(print())
                    .andExpect(jsonPath("$.*", hasSize(5)))
                    .andExpect(jsonPath("$.id", greaterThan(0)))
                    .andExpect(jsonPath("$.name").value("Rapid Spring Boot Application Development"))
                    .andExpect(jsonPath("$.category").value("Spring"))
                    .andExpect(jsonPath("$.rating").value(5))
                    .andExpect(status().isOk());


    }
}
