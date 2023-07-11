package com.example.shopspring.service;

import com.example.shopspring.model.Product;
import com.example.shopspring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        List<Product> productsList = productRepository.getAll();
        if (productsList.isEmpty()) {
            System.out.println("Product list is empty");
        }
        return productsList;
    }

    @Override
    public Product getById(int id) {
        if (id == 0) {
            System.out.println("Incorrect id " + id);
            return null;
        }
        Product product = productRepository.getByIdProduct(id);
        if (product == null) {
            System.out.println("Product with id " + id + " not found");
        }
        return product;
    }

    @Override
    public Product save(Product product) {
        if (product.getName().isEmpty()) {
            System.out.println("Product name is empty");
            return null;
        }
        return productRepository.save(product);
    }
}
