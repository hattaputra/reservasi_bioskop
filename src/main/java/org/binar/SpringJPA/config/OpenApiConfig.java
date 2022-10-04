package org.binar.SpringJPA.config;

import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenApi(){
        return new OpenAPI()
                .info(new io.swagger.v3.oas.models.info.Info()
                        .title("Reservasi Bioskop - Joko Prabowo")
                        .description("Berikut adalah dokumentasi API Reservasi Bioskop untuk Chapter 04 - 08"));
    }
}
