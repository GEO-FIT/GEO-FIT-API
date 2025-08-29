package com.geofit.geofit.property.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geofit.geofit.property.domain.Floor;

public interface FloorRepository extends JpaRepository<Floor, Integer> {
}
