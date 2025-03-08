package org.example.main.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;


@Configuration
public class ProjectConfig {

    @Bean
    public WebClient webClient() {
        return WebClient.builder().build(); /*Creates a WebClient bean and adds it in the Spring context*/
    }
}
