package com.geofit.geofit.property.service;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.geofit.geofit.property.domain.Dong;
import com.geofit.geofit.property.domain.Floor;
import com.geofit.geofit.property.domain.Property;
import com.geofit.geofit.property.domain.PropertyImage;
import com.geofit.geofit.property.domain.PropertySpecification;
import com.geofit.geofit.property.domain.PropertyType;
import com.geofit.geofit.property.dto.request.PropertyCreateRequest;
import com.geofit.geofit.property.dto.request.PropertyUpdateAnalyzeRequest;
import com.geofit.geofit.property.dto.request.PropertyUpdateRequest;
import com.geofit.geofit.property.dto.response.PropertiesResponse;
import com.geofit.geofit.property.dto.response.PropertyResponse;
import com.geofit.geofit.property.repository.DongRepository;
import com.geofit.geofit.property.repository.FloorRepository;
import com.geofit.geofit.property.repository.PropertyRepository;
import com.geofit.geofit.property.repository.PropertyTypeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PropertyService {

    private final DongRepository dongRepository;
    private final PropertyRepository propertyRepository;
    private final PropertyTypeRepository propertyTypeRepository;
    private final FloorRepository floorRepository;

    public PropertyResponse getProperty(Integer propertyId) {
        Property property = propertyRepository.findById(propertyId).orElse(null);
        return PropertyResponse.from(property);
    }

    public PropertiesResponse getProperties(
        Integer dongId,
        Integer floorId,
        Integer minRent,
        Integer maxRent,
        Integer minArea,
        Integer maxArea
    ) {
        Specification<Property> spec = null;
        spec = Specification.where(PropertySpecification.hasDongId(dongId))
            .and(PropertySpecification.hasFloorId(floorId))
            .and(PropertySpecification.rentGreaterThanOrEqualTo(minRent))
            .and(PropertySpecification.rentLessThanOrEqualTo(maxRent))
            .and(PropertySpecification.areaGreaterThanOrEqualTo(minArea))
            .and(PropertySpecification.areaLessThanOrEqualTo(maxArea));
        List<Property> properties = propertyRepository.findAll(spec);
        return PropertiesResponse.from(properties);
    }

    public List<Dong> getDong() {
        return dongRepository.findAll();
    }

    public List<Floor> getFloor() {
        return floorRepository.findAll();
    }

    public List<PropertyType> getType() {
        return propertyTypeRepository.findAll();
    }

    @Transactional
    public Integer createProperty(PropertyCreateRequest request) {
        Dong dong = dongRepository.findById(request.dongId()).orElse(null);
        PropertyType type = propertyTypeRepository.findById(request.typeId()).orElse(null);
        Floor floor = floorRepository.findById(request.floorId()).orElse(null);

        Property property = PropertyCreateRequest.toEntity(request, dong, type, floor);
        Property createdProperty = propertyRepository.save(property);

        request.imageUrls().forEach(imageUrl -> {
            PropertyImage propertyImage = PropertyImage.builder()
                .property(createdProperty)
                .url(imageUrl)
                .build();
            createdProperty.getImages().add(propertyImage);
        });

        return createdProperty.getId();
    }

    @Transactional
    public void updateProperty(PropertyUpdateRequest request, Integer propertyId) {
        Property property = propertyRepository.findById(propertyId).orElse(null);
        property.updatePdfUrl(request.url());
    }

    @Transactional
    public void updateAnalyze(PropertyUpdateAnalyzeRequest request, Integer propertyId) {
        Property property = propertyRepository.findById(propertyId).orElse(null);
        property.updateAnalyze(request);
    }
}
