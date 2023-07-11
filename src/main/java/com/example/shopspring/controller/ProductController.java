package com.example.shopspring.controller;

import com.example.shopspring.model.Product;
import com.example.shopspring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAll() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public Product product(@PathVariable(name = "id") int id) {
        return productService.getById(id);
    }

    @PostMapping("/create")
    public Product create(@RequestBody Product product) {
        return productService.save(product);
    }
}
