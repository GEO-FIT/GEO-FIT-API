package com.geofit.geofit._common.client.dto;

public record AiChatbotRequest(
    String model,
    String session_id,
    String history,
    String content,
    String stream
) {

}
