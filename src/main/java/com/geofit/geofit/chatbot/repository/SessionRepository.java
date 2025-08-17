package com.geofit.geofit.chatbot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geofit.geofit.chatbot.domain.Session;

public interface SessionRepository extends JpaRepository<Session, Long> {


}
