package com.geofit.geofit.property.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geofit.geofit.property.domain.PropertyType;

public interface PropertyTypeRepository extends JpaRepository<PropertyType, Integer> {
}
