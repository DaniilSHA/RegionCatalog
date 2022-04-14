package com.example.regioncatalog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegionCatalog implements Cloneable {
    private int id;
    private String title;
    private String shortTitle;

    @Override
    public RegionCatalog clone() {
        return new RegionCatalog(id, title, shortTitle);
    }
}
