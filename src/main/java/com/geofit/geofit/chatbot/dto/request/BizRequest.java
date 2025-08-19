package com.geofit.geofit.chatbot.dto.request;

public record BizRequest(
    String province,
    String city,
    String district,
    String category
) {

}
