package com.example.haibazo_entrancetest.service;

import com.example.haibazo_entrancetest.model.ProductVariationOptions;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProductVariationOptionsService {
    List<ProductVariationOptions> createOptions(List<ProductVariationOptions> options);
}
