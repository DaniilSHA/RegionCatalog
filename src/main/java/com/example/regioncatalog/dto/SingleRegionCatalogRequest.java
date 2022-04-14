package com.example.regioncatalog.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SingleRegionCatalogRequest {

    private String title;
    private String shortTitle;

    @JsonCreator
    public SingleRegionCatalogRequest(@JsonProperty("title") String title,
                                      @JsonProperty("shortTitle") String shortTitle) {
        this.title = title;
        this.shortTitle = shortTitle;
        validateData();
    }

    private void validateData() {
        if (title.trim().equals("") || shortTitle.trim().equals("")) {
            throw new RuntimeException("Field could not be empty");
        }
    }
}
