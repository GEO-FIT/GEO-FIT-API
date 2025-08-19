package com.geofit.geofit._common.client.dto;

public record AiChatbotRequest(
    Long session_id,
    String history,
    String content
) {

}
