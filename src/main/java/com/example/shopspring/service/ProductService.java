package com.example.shopspring.service;

import com.example.shopspring.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAll();

    Product getById(int id);

    Product save(Product product);

}
