package com.example.haibazo_entrancetest.service;

import com.example.haibazo_entrancetest.model.ProductVariations;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProductVariationsService {
    List<ProductVariations> createProductVariations(List<ProductVariations> variations);
}
