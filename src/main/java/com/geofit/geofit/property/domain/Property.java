package com.geofit.geofit.property.domain;

import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.geofit.geofit.property.dto.request.PropertyUpdateAnalyzeRequest;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = PROTECTED)
public class Property {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @Column(name = "sido", nullable = false, length = 100)
    private String sido;

    @Column(name = "sigungu", nullable = false, length = 100)
    private String sigungu;

    @JoinColumn(name = "dong_id", nullable = false)
    @ManyToOne(fetch = LAZY)
    private Dong dong;

    @Column(name = "detail_address", nullable = false, length = 255)
    private String detailAddress;

    @JoinColumn(name = "type_id", nullable = false)
    @ManyToOne(fetch = LAZY)
    private PropertyType type;

    @JoinColumn(name = "floor_id", nullable = false)
    @ManyToOne(fetch = LAZY)
    private Floor floor;

    @Column(name = "area", nullable = false)
    private Integer area;

    @Column(name = "rent", nullable = false)
    private Integer rent;

    @Column(name = "is_maintenance", nullable = false)
    private Boolean isMaintenance = false;

    @Column(name = "deposit", nullable = false)
    private Integer deposit;

    @Column(name = "pdf_url", nullable = true)
    private String pdfUrl;

    @Column(name = "created_at", insertable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", insertable = false, updatable = false)
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PropertyImage> images = new ArrayList<>();

    @Column(name = "rent_position", length = 255)
    private String rentPosition;

    @Column(name = "reason1", length = 255)
    private String reason1;

    @Column(name = "reason2", length = 255)
    private String reason2;

    @Column(name = "reason3", length = 255)
    private String reason3;

    @Column(name = "economy", length = 255)
    private String economy;

    @Column(name = "demand", length = 255)
    private String demand;

    @Column(name = "environment", length = 255)
    private String environment;

    @Column(name = "rec1_type", length = 100)
    private String rec1Type;

    @Column(name = "rec1_score")
    private Integer rec1Score;

    @Column(name = "rec1_reason", length = 255)
    private String rec1Reason;

    @Column(name = "rec1_way", length = 255)
    private String rec1Way;

    @Column(name = "rec2_type", length = 100)
    private String rec2Type;

    @Column(name = "rec2_score")
    private Integer rec2Score;

    @Column(name = "rec2_reason", length = 255)
    private String rec2Reason;

    @Column(name = "rec2_way", length = 255)
    private String rec2Way;

    @Column(name = "rec3_type", length = 100)
    private String rec3Type;

    @Column(name = "rec3_score")
    private Integer rec3Score;

    @Column(name = "rec3_reason", length = 255)
    private String rec3Reason;

    @Column(name = "rec3_way", length = 255)
    private String rec3Way;

    @Builder
    private Property (
        String sido,
        String sigungu,
        Dong dong,
        String detailAddress,
        PropertyType type,
        Floor floor,
        Integer area,
        Integer rent,
        Boolean isMaintenance,
        Integer deposit,
        String pdfUrl
    ) {
        this.sido = sido;
        this.sigungu = sigungu;
        this.dong = dong;
        this.detailAddress = detailAddress;
        this.type = type;
        this.floor = floor;
        this.area = area;
        this.rent = rent;
        this.isMaintenance = isMaintenance;
        this.deposit = deposit;
        this.pdfUrl = pdfUrl;
    }

    public void updatePdfUrl(String pdfUrl) {
        this.pdfUrl = pdfUrl;
    }

    public void updateAnalyze(PropertyUpdateAnalyzeRequest request) {
        this.reason1 = request.reason1();
        this.reason2 = request.reason2();
        this.reason3 = request.reason3();
        this.rentPosition = request.rentPosition();
        this.economy = request.economy();
        this.demand = request.demand();
        this.environment = request.environment();
        this.rec1Type = request.rec1Type();
        this.rec1Score = request.rec1Score();
        this.rec1Reason = request.rec1Reason();
        this.rec1Way = request.rec1Way();
        this.rec2Type = request.rec2Type();
        this.rec2Score = request.rec2Score();
        this.rec2Reason = request.rec2Reason();
        this.rec2Way = request.rec2Way();
        this.rec3Type = request.rec3Type();
        this.rec3Score = request.rec3Score();
        this.rec3Reason = request.rec3Reason();
        this.rec3Way = request.rec3Way();
    }
}
