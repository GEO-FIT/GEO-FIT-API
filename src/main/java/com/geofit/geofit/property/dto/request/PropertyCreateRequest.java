package com.geofit.geofit.property.dto.request;

import java.util.List;

import com.geofit.geofit.property.domain.Dong;
import com.geofit.geofit.property.domain.Floor;
import com.geofit.geofit.property.domain.Property;
import com.geofit.geofit.property.domain.PropertyType;

public record PropertyCreateRequest(
    String sido,
    String sigungu,
    Integer dongId,
    String detailAddress,
    Integer typeId,
    Integer floorId,
    Integer area,
    Integer rent,
    List<String> imageUrls,
    Boolean isMaintenance,
    Integer deposit
) {

    public static Property toEntity(
        PropertyCreateRequest request,
        Dong dong,
        PropertyType type,
        Floor floor
    ) {
        return Property.builder()
            .sido(request.sido)
            .sigungu(request.sigungu())
            .dong(dong)
            .detailAddress(request.detailAddress)
            .type(type)
            .floor(floor)
            .area(request.area)
            .rent(request.rent)
            .isMaintenance(request.isMaintenance)
            .deposit(request.deposit)
            .build();
    }
}
