package com.example.haibazo_entrancetest.service;

import com.example.haibazo_entrancetest.dto.ProductCreateRequestDTO;
import com.example.haibazo_entrancetest.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public interface IProductService {
    Page<Product> findAllProduct(Pageable pageable);

    Product createProduct(ProductCreateRequestDTO product);

    Optional<Product> findProductById(Long id);
     int publishProductById(Long id);
}
