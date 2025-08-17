package com.geofit.geofit.chatbot.domain;

import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = PROTECTED)
public class Message {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @JoinColumn(name = "session_id", nullable = false)
    @ManyToOne(fetch = LAZY)
    private Session session;

    @Column(name = "is_user", nullable = false)
    private Boolean isUser;

    @Lob
    @Column(name = "content", nullable = false, columnDefinition = "TEXT")
    private String content;

    @Builder
    private Message(
        Session session,
        Boolean isUser,
        String content
    ) {
        this.session = session;
        this.isUser = isUser;
        this.content = content;
    }
}
