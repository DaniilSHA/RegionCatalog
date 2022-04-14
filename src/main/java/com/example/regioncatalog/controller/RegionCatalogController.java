package com.example.regioncatalog.controller;

import com.example.regioncatalog.dto.ListRegionCatalogResponse;
import com.example.regioncatalog.dto.SingleRegionCatalogRequest;
import com.example.regioncatalog.model.RegionCatalog;
import com.example.regioncatalog.service.RegionCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/region-catalog")
public class RegionCatalogController {

    @Autowired
    private RegionCatalogService regionCatalogService;

    @GetMapping("/all")
    public ListRegionCatalogResponse findAll() {
        List<RegionCatalog> list = regionCatalogService.findAll();
        return new ListRegionCatalogResponse(list);
    }

    @GetMapping("/{catalogId}")
    public ListRegionCatalogResponse findById(@PathVariable("catalogId") Integer catalogId) {
        RegionCatalog catalogById = regionCatalogService.findById(catalogId);
        if (catalogById == null) throw new RuntimeException("RegionCatalog don't find");
        return new ListRegionCatalogResponse(Arrays.asList(catalogById));
    }

    @PostMapping("/create")
    public void insert(@RequestBody SingleRegionCatalogRequest singleRegionCatalogRequest) {
        regionCatalogService.save(fromSingleRegionCatalogRequest(singleRegionCatalogRequest));
    }

    @PutMapping("/update/{catalogId}")
    public void update(@RequestBody SingleRegionCatalogRequest singleRegionCatalogRequest,
                       @PathVariable("catalogId") Integer catalogId) {
        if (regionCatalogService.findById(catalogId) == null) throw new RuntimeException("RegionCatalog don't find");
        regionCatalogService.update(catalogId, fromSingleRegionCatalogRequest(singleRegionCatalogRequest));
    }

    @DeleteMapping("/delete/{catalogId}")
    public void delete(@PathVariable("catalogId") Integer catalogId) {
        if (regionCatalogService.findById(catalogId) == null) throw new RuntimeException("RegionCatalog don't find");
        regionCatalogService.delete(catalogId);
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
