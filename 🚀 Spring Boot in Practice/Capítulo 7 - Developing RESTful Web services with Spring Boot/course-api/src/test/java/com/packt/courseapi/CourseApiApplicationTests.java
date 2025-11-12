package com.packt.courseapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import com.packt.courseapi.domain.Course;
import com.packt.courseapi.service.CourseService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.number.OrderingComparison.greaterThan;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
// habilita e configura automaticamente o MockMVC, permitindo autowire da instância e seu uso nos testes
@ExtendWith(SpringExtension.class)
class CourseApiApplicationTests {

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
                .description("Rapid Spring Boot Course")
                .build();

        ObjectMapper objectMapper = new ObjectMapper();

        MockHttpServletResponse response =
                mockMvc.perform( // executa uma chamada API simulada
                                post("/courses/") // a chamada será um POST para o endpoint /courses/
                                        .contentType("application/json") // informamos a API que estamos enviando dados no formato JSON
                                        .content(objectMapper.writeValueAsString(course))) // o corpo, payload, é um objeto course convertido em JSON
                        .andDo(print())
                        .andExpect(jsonPath("$.*", hasSize(5))) // esperamos que o JSON da resposta tenha 5 campos
                        .andExpect(jsonPath("$.id", greaterThan(0))) // esperamos que o campo id seja maior do que 0
                        .andExpect(jsonPath("$.name").value("Rapid Spring Boot Application Development"))
                        .andExpect(jsonPath("$.category").value("Spring"))
                        .andExpect(jsonPath("$.rating").value(5))
                        .andExpect(jsonPath("$.description").value("Rapid Spring Boot Course"))
                        .andExpect(status().isCreated()).andReturn().getResponse();

        Integer id = JsonPath.parse(response.getContentAsString()).read("$.id");
        assertNotNull(courseService.getCourseById(id));

    }

    @Test
    void contextLoads() {
    }

}
