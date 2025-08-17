package com.geofit.geofit._common.client;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.geofit.geofit._common.client.dto.AiChatbotRequest;
import com.geofit.geofit._common.client.dto.AiChatbotResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AiClient {

    private final WebClient aiWebClient;

    public AiChatbotResponse chatbot(AiChatbotRequest request) {
        return aiWebClient.post()
            .uri("/generate") //TODO : url 경로로 바꾸기
            .bodyValue(request)
            .retrieve()
            .bodyToMono(AiChatbotResponse.class)
            .block();
    }
}
