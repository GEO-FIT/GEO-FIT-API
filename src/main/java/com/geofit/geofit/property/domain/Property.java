package com.geofit.geofit.property.domain;

import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
}
