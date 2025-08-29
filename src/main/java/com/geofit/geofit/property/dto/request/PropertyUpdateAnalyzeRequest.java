package com.geofit.geofit.property.dto.request;

public record PropertyUpdateAnalyzeRequest(
    String reason1,
    String reason2,
    String reason3,
    String rentPosition,
    String economy,
    String demand,
    String environment,
    String rec1Type,
    Integer rec1Score,
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

}
