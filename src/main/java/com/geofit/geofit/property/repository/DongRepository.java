package com.geofit.geofit.property.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geofit.geofit.property.domain.Dong;

public interface DongRepository extends JpaRepository<Dong, Integer> {

    Optional<Dong> findByName(String name);
}
