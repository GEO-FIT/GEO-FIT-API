package com.geofit.geofit.chatbot.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.geofit.geofit._common.client.AiClient;
import com.geofit.geofit._common.client.dto.AiChatbotRequest;
import com.geofit.geofit._common.client.dto.AiChatbotResponse;
import com.geofit.geofit.chatbot.domain.Message;
import com.geofit.geofit.chatbot.domain.Session;
import com.geofit.geofit.chatbot.dto.request.MessageRequest;
import com.geofit.geofit.chatbot.dto.response.MessageResponse;
import com.geofit.geofit.chatbot.dto.response.MessagesResponse;
import com.geofit.geofit.chatbot.repository.MessageRepository;
import com.geofit.geofit.chatbot.repository.SessionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ChatbotService {

    private final MessageRepository messageRepository;
    private final SessionRepository sessionRepository;
    private final AiClient aiClient;

    public List<Session> getSessions() {
        return sessionRepository.findAll();
    }

    public MessagesResponse getMessages(Long sessionId) {
        List<Message> messages = messageRepository.findBySessionId(sessionId);
        return MessagesResponse.from(messages);
    }

    @Transactional
    public Session createSession() {
        Session session = Session.builder()
            .title("새 채팅")
            .build();
        return sessionRepository.save(session);
    }

    @Transactional
    public MessageResponse createMessage(Long sessionId, MessageRequest request) {
        Session session = sessionRepository.findById(sessionId).orElse(null);
        List<Message> messages = messageRepository.findBySessionId(sessionId);
        String history = "";

        if (messages.isEmpty()) {
            // TODO 제목요약 AI APi 요청 후 그 응답값으로 session의 title 갱신하기 (비동기로 분리)
        } else {
            history = messages.stream()
                .map(m -> (m.getIsUser() ? "user: " : "bot: ") + m.getContent())
                .collect(Collectors.joining("\n"));
        }

        Message userMessage = Message.builder()
            .session(session)
            .isUser(true)
            .content(request.content())
            .build();
        messageRepository.save(userMessage);

        AiChatbotRequest aiRequest = new AiChatbotRequest(
            sessionId,
            history,
            request.content()
        );
        AiChatbotResponse aiResponse = aiClient.chatbot(aiRequest);

        Message botMessage = Message.builder()
            .session(session)
            .isUser(false)
            .content(aiResponse.content())
            .build();
        messageRepository.save(botMessage);

        return MessageResponse.from(aiResponse);
    }
}
