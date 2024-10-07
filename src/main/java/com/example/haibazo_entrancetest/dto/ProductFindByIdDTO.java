package com.example.haibazo_entrancetest.dto;

import com.example.haibazo_entrancetest.model.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductFindByIdDTO {
    private Double price;
    private Product product;

    public ProductFindByIdDTO(Double price, Product product) {
        this.price = price;
        this.product = product;
    }

    public ProductFindByIdDTO() {
    }
}



