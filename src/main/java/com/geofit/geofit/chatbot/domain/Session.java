package com.geofit.geofit.chatbot.domain;

import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "session")
@NoArgsConstructor(access = PROTECTED)
public class Session {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id; // BIGINT 매핑

    @Column(name = "title", nullable = false, length = 255)
    private String title;

    @Builder
    private Session(String title) {
        this.title = title;
    }
}
