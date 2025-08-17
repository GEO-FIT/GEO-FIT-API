package com.geofit.geofit.chatbot.service;

import org.springframework.stereotype.Service;

import com.geofit.geofit.chatbot.repository.MessageRepository;
import com.geofit.geofit.chatbot.repository.SessionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChatbotService {

    private final MessageRepository messageRepository;
    private final SessionRepository sessionRepository;


}
