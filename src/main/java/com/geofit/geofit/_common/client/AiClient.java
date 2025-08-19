package com.geofit.geofit._common.client;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.geofit.geofit._common.client.dto.request.AiChatbotRequest;
import com.geofit.geofit._common.client.dto.request.SessionNameRequest;
import com.geofit.geofit._common.client.dto.response.AiChatbotResponse;
import com.geofit.geofit._common.client.dto.response.SessionNameResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AiClient {

    private final WebClient aiWebClient;

    public AiChatbotResponse chatbot(AiChatbotRequest request) {
        return aiWebClient.post()
            .uri("/chat/jsonl")
            .bodyValue(request)
            .retrieve()
            .bodyToMono(AiChatbotResponse.class)
            .block();
    }

    public SessionNameResponse sessionName(SessionNameRequest request) {
        return aiWebClient.post()
            .uri("/api/generate-title")
            .bodyValue(request)
            .retrieve()
            .bodyToMono(SessionNameResponse.class)
            .block();
    }
}
