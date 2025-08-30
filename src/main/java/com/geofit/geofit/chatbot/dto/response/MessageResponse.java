package com.geofit.geofit.chatbot.dto.response;

import java.util.Collections;
import java.util.List;

import com.geofit.geofit._common.client.dto.response.AiChatbotResponse;

public record MessageResponse(
    String type,
    String content,
    List<Integer> ids
) {

    public static MessageResponse from(AiChatbotResponse response, List<Integer> ids) {
        return new MessageResponse(response.type(), response.content(), ids != null ? ids : Collections.emptyList());
    }
}
