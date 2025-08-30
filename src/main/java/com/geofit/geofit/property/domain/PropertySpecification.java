package com.geofit.geofit.property.domain;

import org.springframework.data.jpa.domain.Specification;

public class PropertySpecification {

    public static Specification<Property> hasDongId(Integer dongId) {
        return (root, query, cb) -> dongId == null ? null : cb.equal(root.get("dong").get("id"), dongId);
    }

    public static Specification<Property> hasFloorId(Integer floorId) {
        return (root, query, cb) -> floorId == null ? null : cb.equal(root.get("floor").get("id"), floorId);
    }

    public static Specification<Property> rentGreaterThanOrEqualTo(Integer minRent) {
        return (root, query, cb) -> minRent == null ? null : cb.greaterThanOrEqualTo(root.get("rent"), minRent);
    }

    public static Specification<Property> rentLessThanOrEqualTo(Integer maxRent) {
        return (root, query, cb) -> maxRent == null ? null : cb.lessThanOrEqualTo(root.get("rent"), maxRent);
    }

    public static Specification<Property> areaGreaterThanOrEqualTo(Integer minArea) {
        return (root, query, cb) -> minArea == null ? null : cb.greaterThanOrEqualTo(root.get("area"), minArea);
    }

    public static Specification<Property> areaLessThanOrEqualTo(Integer maxArea) {
        return (root, query, cb) -> maxArea == null ? null : cb.lessThanOrEqualTo(root.get("area"), maxArea);
    }

    public static Specification<Property> hasType(String type) {
        return (root, query, cb) -> type == null || type.isEmpty() ? null : cb.equal(root.get("rec1_type"), type);
    }
}
