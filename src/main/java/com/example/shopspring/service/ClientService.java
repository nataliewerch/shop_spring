package com.example.shopspring.service;

import com.example.shopspring.model.Client;
import com.example.shopspring.model.Product;


import java.util.List;

public interface ClientService {

    List<Client> getAll();

    Client getById(int id);

    Client save(Client client);

    void addProductToBasket(Client client, Product product);

    void removeProductFromBasket(Client client, Product product);

}
