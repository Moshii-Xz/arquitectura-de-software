package com.agrointeligente.backend.auth.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("Agro Inteligente API")
                .version("1.0.0")
                .description("API REST para la plataforma Agro Inteligente - Sistema de inteligencia agricola")
                .contact(new Contact()
                    .name("Agro Inteligente Team")
                    .email("support@agrointeligente.com")
                    .url("https://www.agrointeligente.com")))
            .components(new io.swagger.v3.oas.models.Components()
                .addSecuritySchemes("bearerAuth",
                    new SecurityScheme()
                        .type(SecurityScheme.Type.HTTP)
                        .scheme("bearer")
                        .bearerFormat("JWT")
                        .description("JWT Bearer Token")));
    }
}
