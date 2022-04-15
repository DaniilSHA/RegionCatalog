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
    @CachePut(cacheNames = "region_catalog", key = "#regionCatalogForSave.id")
    public RegionCatalog save(RegionCatalog regionCatalogForSave) {
        logger.info("*** ВЫПОЛНЕНИЕ save() В БАЗЕ ДАННЫХ ***");
        regionCatalogMapper.save(regionCatalogForSave);
        regionCatalogForSave.setId(regionCatalogMapper.getMaxId());
        return makeRegionCatalogEntity(regionCatalogForSave);
    }

    @Override
    @CachePut(cacheNames = "region_catalog", key = "#catalogId")
    public RegionCatalog update(Integer catalogId, RegionCatalog regionCatalogForUpdate) {
        logger.info("*** ВЫПОЛНЕНИЕ update() В БАЗЕ ДАННЫХ ***");
        regionCatalogMapper.update(catalogId, regionCatalogForUpdate);
        return makeRegionCatalogEntity(catalogId, regionCatalogForUpdate);
    }

    @Override
    @CacheEvict(cacheNames = "region_catalog", key = "#catalogId")
    public RegionCatalog delete(Integer catalogId) {
        logger.info("*** ВЫПОЛНЕНИЕ delete() В БАЗЕ ДАННЫХ ***");
        RegionCatalog deletedRegionCatalog = regionCatalogMapper.findById(catalogId);
        regionCatalogMapper.delete(catalogId);
        return makeRegionCatalogEntity(catalogId, deletedRegionCatalog);
    }

    private RegionCatalog makeRegionCatalogEntity(Integer catalogId, RegionCatalog fromRegionCatalog) {
        return new RegionCatalog(catalogId,
                fromRegionCatalog.getTitle(),
                fromRegionCatalog.getShortTitle()
        );
    }

    private RegionCatalog makeRegionCatalogEntity (RegionCatalog fromRegionCatalog) {
        return fromRegionCatalog.clone();
    }
}
