package com.geofit.geofit.chatbot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geofit.geofit.chatbot.domain.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {


}
