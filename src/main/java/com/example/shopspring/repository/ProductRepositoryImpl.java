package com.example.shopspring.repository;

import com.example.shopspring.model.Product;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private Map<Integer, Product> productMap = new HashMap<>();

    @PostConstruct
    private void init() {
        productMap.put(1, new Product(1, "Table", 2300.00));
        productMap.put(2, new Product(2, "Sofa", 3500.25));
        productMap.put(3, new Product(3, "Couch", 820.34));
        productMap.put(4, new Product(4, "Bed", 1399.99));
        productMap.put(5, new Product(5, "Chair", 250.00));
        productMap.put(6, new Product(6, "Closet", 3880.00));
        productMap.put(7, new Product(7, "Lamp", 130.00));
        productMap.put(8, new Product(8, "Rocker", 1100.00));
        productMap.put(9, new Product(9, "Bookcase", 2500.00));
        productMap.put(10, new Product(10, "Ottoman", 930.00));
        productMap.put(11, new Product(11, "Wardrobe", 4230.00));

    }

    @Override
    public List<Product> getAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public Product getByIdProduct(int id) {
        return productMap.get(id);
    }

    @Override
    public Product save(Product product) {
        int lastId = productMap.keySet().stream().mapToInt(s -> s).max().getAsInt();
        product.setId(lastId + 1);
        productMap.put(product.getId(), product);
        return product;
    }
}
