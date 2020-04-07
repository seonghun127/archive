package com.example.springpractice.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public ObjectMapper customObjectMapper() {
        return new ObjectMapper();
    }
}
