package com.geofit.geofit.property.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geofit.geofit.property.domain.Dong;
import com.geofit.geofit.property.domain.Floor;
import com.geofit.geofit.property.domain.PropertyType;
import com.geofit.geofit.property.dto.request.PropertyCreateRequest;
import com.geofit.geofit.property.dto.request.PropertyUpdateAnalyzeRequest;
import com.geofit.geofit.property.dto.request.PropertyUpdateRequest;
import com.geofit.geofit.property.dto.response.PropertyResponse;
import com.geofit.geofit.property.service.PropertyService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/property")
public class PropertyController {

    private final PropertyService propertyService;

    @GetMapping("/{propertyId}")
    public ResponseEntity<PropertyResponse> getProperty(
        @PathVariable Integer propertyId
    ) {
        PropertyResponse response = propertyService.getProperty(propertyId);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Integer> createProperty(
        @RequestBody PropertyCreateRequest request
    ) {
        Integer propertyId = propertyService.createProperty(request);
        return ResponseEntity.ok(propertyId);
    }

    @PutMapping("/{propertyId}")
    public ResponseEntity<Void> updateProperty(
        @RequestBody PropertyUpdateRequest request,
        @PathVariable Integer propertyId
    ) {
        propertyService.updateProperty(request, propertyId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/analyze/{propertyId}")
    public ResponseEntity<Void> updateAnalyze(
        @RequestBody PropertyUpdateAnalyzeRequest request,
        @PathVariable Integer propertyId
    ) {
        propertyService.updateAnalyze(request, propertyId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/dong")
    public ResponseEntity<List<Dong>> getDong() {
        List<Dong> response = propertyService.getDong();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/floor")
    public ResponseEntity<List<Floor>> getFloor() {
        List<Floor> response = propertyService.getFloor();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/type")
    public ResponseEntity<List<PropertyType>> getType() {
        List<PropertyType> response = propertyService.getType();
        return ResponseEntity.ok(response);
    }
}
