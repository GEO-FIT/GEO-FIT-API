package com.geofit.geofit._common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient aiWebClient(WebClient.Builder builder) {
        return builder
            .baseUrl("http://ai-server:8080") //TODO : 실제 ai URL로 바꾸기
            .build();
    }
}
