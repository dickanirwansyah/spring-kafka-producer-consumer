package com.dicka.kafkaconsumer.controller;

import com.dicka.kafkaconsumer.model.ProductDetail;
import com.dicka.kafkaconsumer.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/kafka")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/join")
    public List<ProductDetail> productDetails(){
        return productService.listProducts();
    }
}
