package com.example.haibazo_entrancetest.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ProductFindAllDTO {
    private Long id;
    private String name;
    private String thumb;
    private String slug;
    private float rating;
    private Double price;
    private Double final_price;

    public ProductFindAllDTO(Long id, String name, String thumb, String slug, float rating, Double price, Double final_price) {
        this.id = id;
        this.name = name;
        this.thumb = thumb;
        this.slug = slug;
        this.rating = rating;
        this.price = price;
        this.final_price = final_price;
    }
}
