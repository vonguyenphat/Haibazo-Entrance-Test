package com.example.haibazo_entrancetest.controller;

import com.example.haibazo_entrancetest.dto.ProductCreateRequestDTO;
import com.example.haibazo_entrancetest.exception.ApiRequestException;
import com.example.haibazo_entrancetest.service.iml.ProductServiceIml;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String createProduct(@RequestBody ProductCreateRequestDTO productCreateRequestDTO){
        try{
            System.out.println(productCreateRequestDTO);
            productService.createProduct(productCreateRequestDTO);
            return null;
        }catch (Exception ex){
            throw new ApiRequestException(ex.getMessage());
        }
    }
}
