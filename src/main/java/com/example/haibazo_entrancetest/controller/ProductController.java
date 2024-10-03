package com.example.haibazo_entrancetest.controller;

import com.example.haibazo_entrancetest.dto.ProductCreateRequestDTO;
import com.example.haibazo_entrancetest.exception.ApiRequestException;
import com.example.haibazo_entrancetest.service.iml.ProductServiceIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/products")
public class ProductController {
    @Autowired
    ProductServiceIml productService;
    @GetMapping
    public String getAllPublishedForProduct(){
       return "hello";
    }
    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody ProductCreateRequestDTO productCreateRequestDTO){
        try{
            return ResponseEntity.ok(productService.createProduct(productCreateRequestDTO));
        }catch (Exception ex){
            throw new ApiRequestException(ex.getMessage());
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable("id") long id){
        try{
            return ResponseEntity.ok(productService.findProductById(id));
        }catch (Exception ex){
            throw new ApiRequestException(ex.getMessage());
        }
    }
}
