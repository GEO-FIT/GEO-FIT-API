package com.geofit.geofit._common.client.dto.request;

public record AiChatbotRequest(
    Long session_id,
    String history,
    String content
) {

}
