package org.example.main.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;


/*Habilitamos os clientes do OpenFeign e
informamos à dependência do OpenFeign onde
para procurar os contratos de proxy.*/
@Configuration
@EnableFeignClients ( basePackages = "org.example.main.proxy")
public class ProjectConfig {
}
