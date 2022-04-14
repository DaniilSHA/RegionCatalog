package com.example.regioncatalog.service;

import com.example.regioncatalog.model.RegionCatalog;

import java.util.List;

public interface RegionCatalogService {

    List<RegionCatalog> findAll();

    RegionCatalog findById(Integer catalogId);

    RegionCatalog save(RegionCatalog fromSingleRegionCatalogRequest);

    RegionCatalog update(Integer catalogId, RegionCatalog fromSingleRegionCatalogRequest);

    RegionCatalog delete(Integer catalogId);
}
