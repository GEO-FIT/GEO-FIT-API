package com.geofit.geofit.property.dto.response;

import java.util.List;

import com.geofit.geofit.property.domain.Property;

public record PropertiesResponse(
    Integer count,
    List<InnerPropertyResponse> properties
) {

    public record InnerPropertyResponse(
        Integer propertyId,
        String dong,
        String floor,
        String propertyType,
        Integer area,
        Integer rent,
        Integer deposit,
        String rec1Type,
        String rec2Type,
        String rec3Type,
        String reason1,
        String reason2,
        String reason3
    ) {

        private static InnerPropertyResponse from(Property property) {
            return new InnerPropertyResponse(
                property.getId(),
                property.getDong().getName(),
                property.getFloor().getName(),
                property.getType().getName(),
                property.getArea(),
                property.getRent(),
                property.getDeposit(),
                property.getRec1Type(),
                property.getRec2Type(),
                property.getRec3Type(),
                property.getReason1(),
                property.getReason2(),
                property.getReason3()
            );
        };
    }

    public static PropertiesResponse from(List<Property> properties) {
        List<InnerPropertyResponse> innerProperties = properties.stream()
            .map(InnerPropertyResponse::from)
            .toList();

        return new PropertiesResponse(innerProperties.size(), innerProperties);
    }
}
