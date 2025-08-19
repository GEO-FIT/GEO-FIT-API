package com.geofit.geofit.chatbot.dto.response;

import com.geofit.geofit._common.client.dto.response.AiChatbotResponse;

public record MessageResponse(
    String type,
    String content,
    String pdfUrl
) {

    public static MessageResponse from(AiChatbotResponse response) {
        return new MessageResponse(response.type(), response.content(), response.pdfUrl());
    }
}
