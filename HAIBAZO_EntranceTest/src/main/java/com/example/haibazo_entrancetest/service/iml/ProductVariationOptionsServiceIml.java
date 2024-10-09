package com.example.haibazo_entrancetest.service.iml;

import com.example.haibazo_entrancetest.model.ProductVariationOptions;
import com.example.haibazo_entrancetest.repository.IProductVariationOptionsRepository;
import com.example.haibazo_entrancetest.service.IProductVariationOptionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductVariationOptionsServiceIml implements IProductVariationOptionsService {
    @Autowired
    IProductVariationOptionsRepository optionsRepository;
    @Override
    public List<ProductVariationOptions> createOptions(List<ProductVariationOptions> options) {
        return optionsRepository.saveAll(options);
    }
}
