package com.example.shopspring.model;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    private List<Product> products = new ArrayList<>();

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void add(Product product) {
        products.add(product);
    }

    public void remove(Product product) {
        products.remove(product);
    }

    @Override
    public String toString() {
        return "Basket{" +
                "productList=" + products +
                '}';
    }
}