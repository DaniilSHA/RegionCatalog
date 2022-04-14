package com.example.regioncatalog.controller;

import com.example.regioncatalog.dto.ListRegionCatalogResponse;
import com.example.regioncatalog.dto.SingleRegionCatalogRequest;
import com.example.regioncatalog.mapper.RegionCatalogMapper;
import com.example.regioncatalog.model.RegionCatalog;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/region-catalog")
public class RegionCatalogController {

    @Autowired
    private RegionCatalogMapper regionCatalogMapper;

    @GetMapping("/all")
    public ListRegionCatalogResponse findAll() {
        List<RegionCatalog> list = regionCatalogMapper.findAll();
        return new ListRegionCatalogResponse(list);
    }

    @GetMapping("/{catalogId}")
    public ListRegionCatalogResponse findById(@PathVariable("catalogId") Integer catalogId) {
        RegionCatalog catalogById = regionCatalogMapper.findById(catalogId);
        if (catalogById == null) throw new RuntimeException("RegionCatalog don't find");
        return new ListRegionCatalogResponse(Arrays.asList(catalogById));
    }

    @PostMapping("/create")
    public void insert(@RequestBody SingleRegionCatalogRequest singleRegionCatalogRequest) {
        regionCatalogMapper.save(fromSingleRegionCatalogRequest(singleRegionCatalogRequest));
    }

    @PutMapping("/update/{catalogId}")
    public void update(@RequestBody SingleRegionCatalogRequest singleRegionCatalogRequest,
                       @PathVariable("catalogId") Integer catalogId) {
        if (regionCatalogMapper.findById(catalogId) == null) throw new RuntimeException("RegionCatalog don't find");
        regionCatalogMapper.update(catalogId, fromSingleRegionCatalogRequest(singleRegionCatalogRequest));
    }

    @DeleteMapping("/delete/{catalogId}")
    public void update(@PathVariable("catalogId") Integer catalogId) {
        if (regionCatalogMapper.findById(catalogId) == null) throw new RuntimeException("RegionCatalog don't find");
        regionCatalogMapper.delete(catalogId);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String exception(Exception exception) {
        return (exception != null ? exception.getMessage() : "Unknown error");
    }

    private RegionCatalog fromSingleRegionCatalogRequest(SingleRegionCatalogRequest singleRegionCatalogRequest) {
        RegionCatalog regionCatalog = new RegionCatalog();
        regionCatalog.setTitle(singleRegionCatalogRequest.getTitle());
        regionCatalog.setShortTitle(singleRegionCatalogRequest.getShortTitle());
        return regionCatalog;
    }
}
