package com.example.haibazo_entrancetest.service.iml;

import com.example.haibazo_entrancetest.model.ProductVariations;
import com.example.haibazo_entrancetest.repository.IProductVariationsRepository;
import com.example.haibazo_entrancetest.service.IProductVariationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductVariationsServiceIml implements IProductVariationsService {
    @Autowired
    IProductVariationsRepository variationsRepository;
    @Override
    public List<ProductVariations> createProductVariations(List<ProductVariations> variations) {
        return variationsRepository.saveAll(variations);
    }
}
