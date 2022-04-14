package com.example.regioncatalog.service;

import com.example.regioncatalog.model.RegionCatalog;

import java.util.List;

public interface RegionCatalogService {

    List<RegionCatalog> findAll();

    RegionCatalog findById(Integer catalogId);

    void save(RegionCatalog fromSingleRegionCatalogRequest);

    void update(Integer catalogId, RegionCatalog fromSingleRegionCatalogRequest);

    void delete(Integer catalogId);
}
