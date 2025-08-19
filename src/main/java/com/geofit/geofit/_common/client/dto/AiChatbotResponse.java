package com.geofit.geofit._common.client.dto;

public record AiChatbotResponse(
    String type,
    String content,
    String pdfUrl,
    String province,
    String city,
    String district,
    String category
) {

}
