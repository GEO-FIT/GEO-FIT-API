package com.geofit.geofit.chatbot.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        Message userMessage = Message.builder()
            .session(session)
            .isUser(true)
            .content(request.content())
            .build();
        messageRepository.save(userMessage);

        // TODO
        // AI 서버에 요청 보내고 응답 받기까지 대기 (응답값 형태 : 채팅 응답값 내용)

        // === 임시 딜레이 ===
        try {
            Thread.sleep(3000); // 3초 대기
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        // === AI 서버 ===

        Message botMessage = Message.builder()
            .session(session)
            .isUser(false)
            .content("나중에 AI서버 응답값으로 변경")
            .build();
        messageRepository.save(botMessage);
        return new MessageResponse(botMessage.getContent());
    }
}
