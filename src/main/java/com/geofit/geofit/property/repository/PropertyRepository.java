package com.geofit.geofit.property.repository;

import com.geofit.geofit.property.domain.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<Property, Integer> {

}
