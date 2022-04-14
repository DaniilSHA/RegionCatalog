package com.example.regioncatalog.controller;

import com.example.regioncatalog.dto.ListRegionCatalogResponse;
import com.example.regioncatalog.mapper.RegionCatalogMapper;
import com.example.regioncatalog.model.RegionCatalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/region-catalog")
public class RegionCatalogController {

    @Autowired
    private RegionCatalogMapper regionCatalogMapper;

    @GetMapping("/all")
    public ListRegionCatalogResponse findAll(){
        List<RegionCatalog> list = regionCatalogMapper.findAll();
        return new ListRegionCatalogResponse(list);
    }

    @GetMapping("/{catalogId}")
    public ListRegionCatalogResponse findById(@PathVariable("catalogId") Integer catalogId){
        RegionCatalog catalogById = regionCatalogMapper.findById(catalogId);
        if (catalogById == null) throw new RuntimeException("RegionCatalog don't find");
        return new ListRegionCatalogResponse(Arrays.asList(catalogById));
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String exception(Exception exception) {
        return (exception != null ? exception.getMessage() : "Unknown error");
    }
}
