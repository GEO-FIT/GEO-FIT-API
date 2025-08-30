package com.geofit.geofit.property.repository;

import java.util.List;

import com.geofit.geofit.property.domain.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import com.geofit.geofit.property.domain.Dong;

public interface PropertyRepository extends JpaRepository<Property, Integer>, JpaSpecificationExecutor<Property> {

    List<Property> findTop3ByDongAndRec1TypeOrderByRec1ScoreDesc(Dong dong, String rec1Type);
}
