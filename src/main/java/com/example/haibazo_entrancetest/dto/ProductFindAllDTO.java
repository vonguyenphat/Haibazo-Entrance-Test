package com.example.haibazo_entrancetest.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Setter
@Getter
@NoArgsConstructor
public class ProductFindAllDTO {
    @Id
    private Long id;
    private String name;
    private String thumb;
    private String slug;
    private float rating;
    private Double price;

    public ProductFindAllDTO(Long id, String name, String thumb, String slug, float rating, Double price) {
        this.id = id;
        this.name = name;
        this.thumb = thumb;
        this.slug = slug;
        this.rating = rating;
        this.price = price;
    }
}
