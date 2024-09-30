package com.example.haibazo_entrancetest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/product")
public class ProductController {
    @GetMapping
    public String hello(){
        return "helloword";
    }

}
