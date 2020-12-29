package com.training.ykb.rest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class RestConfig {

    @Bean
    public OpenAPI openAPICreate() {
        return new OpenAPI().info(new Info().title("Title")
                                            .description("Test description")
                                            .version("1.0.1"));
    }


}
