package com.example.regioncatalog.dto;

import com.example.regioncatalog.model.RegionCatalog;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ListRegionCatalogResponse {

    private List<RegionCatalog> regionCatalogList;

    public ListRegionCatalogResponse(List<RegionCatalog> regionCatalogList) {
        this.regionCatalogList = regionCatalogList;
    }

    @JsonProperty
    public List<RegionCatalog> getRegionCatalogList() {
        return regionCatalogList;
    }
}
