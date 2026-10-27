package com.example.portfolioApi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    // URL du front en ligne (définie dans Render). En local, valeur par défaut.
    @Value("${FRONT_URL:http://localhost:5173}")
    private String frontUrl;

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**")
                        .allowedOrigins(
                            "http://localhost:5173",
                            "http://127.0.0.1:5173",
                            "http://localhost:3000",
                            frontUrl);
            }
        };
    }
}