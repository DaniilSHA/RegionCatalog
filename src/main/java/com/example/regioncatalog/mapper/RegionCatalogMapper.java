package com.example.regioncatalog.mapper;

import com.example.regioncatalog.model.RegionCatalog;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RegionCatalogMapper {

    @Select("select * from region_catalog")
    List<RegionCatalog> findAll();

    @Select("select * from region_catalog where id = #{id}")
    RegionCatalog findById(@Param("id") int catalogId);

    @Insert("insert into region_catalog (title, shortTitle) values (#{title}, #{shortTitle})")
    void save(RegionCatalog newRegionCatalog);

    @Update("update region_catalog set " +
            "title=#{updatedRegionCatalog.title}, " +
            "shortTitle=#{updatedRegionCatalog.shortTitle} " +
            "where id=#{id}")
    void update(@Param("id") Integer catalogId, RegionCatalog updatedRegionCatalog);

    @Delete("delete from region_catalog where id = #{id}")
    void delete(@Param("id") Integer catalogId);
}
