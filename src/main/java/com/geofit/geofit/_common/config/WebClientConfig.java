package com.geofit.geofit._common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient aiWebClient(WebClient.Builder builder) {
        return builder
            .baseUrl("http://125.138.158.48:5000")
            .build();
    }
}
