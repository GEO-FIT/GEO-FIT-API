package com.geofit.geofit.property.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geofit.geofit.property.domain.PropertyImage;

public interface PropertyImageRepository extends JpaRepository<PropertyImage, Integer> {
}
