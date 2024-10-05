package com.example.haibazo_entrancetest.dto;

import com.example.haibazo_entrancetest.model.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@NoArgsConstructor
public class ProductFindByIdDTO {
    Product product;
    Double price;

}
