package com.geofit.geofit.chatbot.dto.response;

import java.util.List;

import com.geofit.geofit.chatbot.domain.Message;

public record MessagesResponse(
    List<InnerMessageResponse> messages
) {

    public record InnerMessageResponse(
        Integer id,
        Boolean isUser,
        String content
    ) {

        private static InnerMessageResponse from(Message message) {
            return new InnerMessageResponse(message.getId(), message.getIsUser(), message.getContent());
        }
    }

    public static MessagesResponse from(List<Message> messages) {
        return new MessagesResponse(messages.stream()
            .map(InnerMessageResponse::from)
            .toList()
        );
    }
}
