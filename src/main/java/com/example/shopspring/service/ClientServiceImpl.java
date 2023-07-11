package com.example.shopspring.service;

import com.example.shopspring.model.Client;
import com.example.shopspring.model.Product;
import com.example.shopspring.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository repository;

    @Override
    public List<Client> getAll() {
        List<Client> clientList = repository.getAll();
        if (clientList.isEmpty()) {
            System.out.println("Client list is empty");
        }
        return clientList;
    }

    @Override
    public Client getById(int id) {
        if (id == 0) {
            System.out.println("Incorrect id " + id);
            return null;
        }
        Client client = repository.getById(id);
        if (client == null) {
            System.out.println("Client with id " + id + " not found");
        }
        return client;
    }

    @Override
    public Client save(Client client) {
        if (client.getLastname().isEmpty()) {
            System.out.println("Lastname is empty");
            return null;
        }
        if (client.getName().isEmpty()) {
            System.out.println("Name is empty");
            return null;
        }
        return repository.save(client);
    }

    @Override
    public void addProductToBasket(Client client, Product product) {
        repository.addProductToBasket(client, product);
    }

    @Override
    public void removeProductFromBasket(Client client, Product product) {
        repository.removeProductFromBasket(client, product);
    }
}
