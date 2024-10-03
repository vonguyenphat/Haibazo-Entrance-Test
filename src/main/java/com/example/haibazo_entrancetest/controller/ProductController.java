package com.example.haibazo_entrancetest.controller;

import com.example.haibazo_entrancetest.dto.ProductCreateRequestDTO;
import com.example.haibazo_entrancetest.exception.ApiRequestException;
import com.example.haibazo_entrancetest.model.Product;
import com.example.haibazo_entrancetest.repository.IProductRepository;
import com.example.haibazo_entrancetest.service.iml.ProductServiceIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/v1/api/products")
public class ProductController {
    @Autowired
    ProductServiceIml productService;
    @Autowired
    IProductRepository productRepository;

    @GetMapping
    public ResponseEntity<Page<Product>> getAllProductHomePage1(
            @RequestParam(value = "category_id", required = false) String categoryId,
            @RequestParam(value = "option_1", required = false) String option_1,
            @RequestParam(value = "option_2", required = false) String option_2,
            @RequestParam(value = "option_3", required = false) String option_3,
            @RequestParam(value = "attribute_value_id", required = false) String attributeValueId,
            @RequestParam(defaultValue = "0") int page) {
        try {
            Pageable pageable = PageRequest.of(page, 12);

            Long categoryIdLong = (categoryId != null && !categoryId.isEmpty()) ? Long.parseLong(categoryId) : null;
            Long attributeValueIdLong = (attributeValueId != null && !attributeValueId.isEmpty()) ? Long.parseLong(attributeValueId) : null;

            Page<Product> productPage = productRepository.findAllProduct(pageable, categoryIdLong, attributeValueIdLong, option_1, option_2, option_3);
            return ResponseEntity.ok().body(productPage);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ApiRequestException(ex.getMessage());
        }
    }


    @GetMapping("/test")
    public ResponseEntity<List<?>> getAllProductHomePage() {
        try {
            return ResponseEntity.ok(productRepository.findAll());
        } catch (Exception ex) {
            throw new ApiRequestException(ex.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody ProductCreateRequestDTO productCreateRequestDTO) {
        try {
            return ResponseEntity.ok(productService.createProduct(productCreateRequestDTO));
        } catch (Exception ex) {
            throw new ApiRequestException(ex.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable("id") long id) {
        try {
            return ResponseEntity.ok(productService.findProductById(id));
        } catch (Exception ex) {
            throw new ApiRequestException(ex.getMessage());
        }
    }

}
