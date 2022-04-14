package com.example.regioncatalog.mapper;

import com.example.regioncatalog.model.RegionCatalog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RegionCatalogMapper {

    @Select("select * from region_catalog")
    List<RegionCatalog> findAll();

    @Select("select * from region_catalog where id = #{catalogId}")
    RegionCatalog findById(int catalogId);
}
