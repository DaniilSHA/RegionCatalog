package com.example.regioncatalog.service;

import com.example.regioncatalog.mapper.RegionCatalogMapper;
import com.example.regioncatalog.model.RegionCatalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.List;

@Service
public class RegionCatalogServiceImpl implements RegionCatalogService {

    @Autowired
    private RegionCatalogMapper regionCatalogMapper;

    private static Logger logger = LoggerFactory.getLogger(RegionCatalogServiceImpl.class);

    @Override
    @Cacheable(cacheNames = "region_catalog")
    public List<RegionCatalog> findAll() {
        logger.info("*** ВЫПОЛНЕНИЕ findAll() В БАЗЕ ДАННЫХ ***");
        return regionCatalogMapper.findAll();
    }

    @Override
    @Cacheable(cacheNames = "region_catalog", key = "#catalogId")
    public RegionCatalog findById(Integer catalogId) {
        logger.info("*** ВЫПОЛНЕНИЕ findById() В БАЗЕ ДАННЫХ ***");
        return regionCatalogMapper.findById(catalogId);
    }

    @Override
    @CachePut(cacheNames = "region_catalog", key = "#fromSingleRegionCatalogRequest.title")
    public void save(RegionCatalog fromSingleRegionCatalogRequest) {
        logger.info("*** ВЫПОЛНЕНИЕ save() В БАЗЕ ДАННЫХ ***");
        regionCatalogMapper.save(fromSingleRegionCatalogRequest);
    }

    @Override
    @CachePut(cacheNames = "region_catalog", key = "#catalogId")
    public void update(Integer catalogId, RegionCatalog fromSingleRegionCatalogRequest) {
        logger.info("*** ВЫПОЛНЕНИЕ update() В БАЗЕ ДАННЫХ ***");
        regionCatalogMapper.update(catalogId, fromSingleRegionCatalogRequest);
    }

    @Override
    @CacheEvict(cacheNames = "region_catalog", key = "#catalogId")
    public void delete(Integer catalogId) {
        logger.info("*** ВЫПОЛНЕНИЕ delete() В БАЗЕ ДАННЫХ ***");
        regionCatalogMapper.delete(catalogId);
    }
}
