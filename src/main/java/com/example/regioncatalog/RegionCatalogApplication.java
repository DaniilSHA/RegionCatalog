package com.example.regioncatalog;

import com.example.regioncatalog.model.RegionCatalog;
import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("com.example.regioncatalog.mapper")
@MappedTypes(RegionCatalog.class)
@EnableCaching
public class RegionCatalogApplication {

    public static void main(String[] args) {
        SpringApplication.run(RegionCatalogApplication.class, args);
    }

}
