package com.example.shopspring.repository;

import com.example.shopspring.model.Product;

import java.util.List;

public interface ProductRepository {

    List<Product> getAll();

    Product getByIdProduct(int id);

    Product save(Product product);
}
