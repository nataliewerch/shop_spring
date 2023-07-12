package com.example.shopspring.service;

import com.example.shopspring.model.Client;

import java.util.List;

public interface ClientService {

    List<Client> getAll();

    Client getById(int id);

    Client save(Client client);

    void addProductToBasket(int clientId, int productId);

    void removeProductFromBasket(int clientId, int productId);

}
