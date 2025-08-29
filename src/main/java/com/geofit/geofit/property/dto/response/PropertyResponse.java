package com.geofit.geofit.property.dto.response;

import java.time.LocalDateTime;
import java.util.List;

import com.geofit.geofit.property.domain.Property;
import com.geofit.geofit.property.domain.PropertyImage;

public record PropertyResponse(
    Integer propertyId,
    String sido,
    String sigungu,
    String dong,
    String detailAddress,
    String propertyType,
    String floor,
    Integer area,
    Integer rent,
    Boolean isMaintenance,
    Integer deposit,
    LocalDateTime createdAt,
    LocalDateTime updatedAt,
    List<String> imageUrls,
    String pdfUrl,
    String rentPosition,
    String reason1,
    String reason2,
    String reason3,
    String economy,
    String demand,
    String environment,
    String rec1Type,
    Integer re1Score,
    String rec1Reason,
    String rec1Way,
    String rec2Type,
    Integer rec2Score,
    String rec2Reason,
    String rec2Way,
    String rec3Type,
    Integer rec3Score,
    String rec3Reason,
    String rec3Way
) {

    public static PropertyResponse from(
        Property property
    ) {
        return new PropertyResponse(
            property.getId(),
            property.getSido(),
            property.getSigungu(),
            property.getDong().getName(),
            property.getDetailAddress(),
            property.getType().getName(),
            property.getFloor().getName(),
            property.getArea(),
            property.getRent(),
            property.getIsMaintenance(),
            property.getDeposit(),
            property.getCreatedAt(),
            property.getUpdatedAt(),
            getUrls(property.getImages()),
            property.getPdfUrl(),
            property.getRentPosition(),
            property.getReason1(),
            property.getReason2(),
            property.getReason3(),
            property.getEconomy(),
            property.getDemand(),
            property.getEnvironment(),
            property.getRec1Type(),
            property.getRec1Score(),
            property.getRec1Reason(),
            property.getRec1Way(),
            property.getRec2Type(),
            property.getRec2Score(),
            property.getRec2Reason(),
            property.getRec2Way(),
            property.getRec3Type(),
            property.getRec3Score(),
            property.getRec3Reason(),
            property.getRec3Way()
        );
    }

    private static List<String> getUrls(List<PropertyImage> images) {
        return images.stream()
            .map(PropertyImage::getUrl)
            .toList();
    }
}
