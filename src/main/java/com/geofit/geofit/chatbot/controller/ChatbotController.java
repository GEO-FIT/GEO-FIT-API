package com.geofit.geofit.chatbot.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geofit.geofit.chatbot.domain.Session;
import com.geofit.geofit.chatbot.dto.request.MessageRequest;
import com.geofit.geofit.chatbot.dto.response.MessageResponse;
import com.geofit.geofit.chatbot.dto.response.MessagesResponse;
import com.geofit.geofit.chatbot.service.ChatbotService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/chatbot")
public class ChatbotController {

    private final ChatbotService chatbotService;

    @GetMapping("/session")
    public ResponseEntity<List<Session>> getSessions() {
        List<Session> response = chatbotService.getSessions();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{sessionId}")
    public ResponseEntity<MessagesResponse> getMessages(
        @PathVariable Long sessionId
    ) {
        MessagesResponse response = chatbotService.getMessages(sessionId);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/session")
    public ResponseEntity<Session> createSession() {
        Session response = chatbotService.createSession();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/{sessionId}")
    public ResponseEntity<MessageResponse> createMessage(
        @PathVariable Long sessionId,
        @RequestBody MessageRequest request
    ) {
        MessageResponse response = chatbotService.createMessage(sessionId, request);
        return ResponseEntity.ok(response);
    }
}
