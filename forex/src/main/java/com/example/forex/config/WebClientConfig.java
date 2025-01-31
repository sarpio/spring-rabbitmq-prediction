package com.example.forex.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Value("${forex.url}")
    private String forexApi;

    @Bean
    public WebClient webClient(WebClient.Builder builder) {
        return builder
                .baseUrl(forexApi)
                .build();
    }
}
