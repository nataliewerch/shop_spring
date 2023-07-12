package com.example.shopspring.repository;

import com.example.shopspring.model.Client;
import com.example.shopspring.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class ClientRepositoryImpl implements ClientRepository {

    @Autowired
    private ProductRepository productRepository;
    private HashMap<Integer, Client> clientMap = new HashMap<>();

    @PostConstruct
    private void init() {
        clientMap.put(1, new Client(1, "Ivan", "Ivanov"));
        clientMap.put(2, new Client(2, "Anton", "Antonov"));
        clientMap.put(3, new Client(3, "Stepan", "Stepanov"));
        clientMap.put(4, new Client(4, "Artur", "Arturov"));
        clientMap.put(5, new Client(5, "Anna", "Ivanova"));
    }

    @Override
    public List<Client> getAll() {
        return new ArrayList<>(clientMap.values());
    }

    @Override
    public Client getById(int id) {
        return clientMap.get(id);
    }

    @Override
    public Client save(Client client) {
        int lastId = clientMap.keySet().stream().mapToInt(s -> s).max().getAsInt();
        client.setId(lastId + 1);
        clientMap.put(client.getId(), client);
        return client;
    }

    @Override
    public void addProductToBasket(int clientId, int productId) {
        Client client = clientMap.get(clientId);
        Product product = productRepository.getByIdProduct(productId);
        if (!clientMap.containsKey(clientId)) {
            System.out.println("Client with id " + clientId + " not found");
            return;
        }
        if (product == null) {
            System.out.println("Product with id " + productId + " not found");
            return;
        }
        client.getProductList().add(product);
    }

    @Override
    public void removeProductFromBasket(int clientId, int productId) {
        if (!clientMap.containsKey(clientId)) {
            System.out.println("Client with id = " + clientId + " not found");
            return;
        }
        Client client = clientMap.get(clientId);
        Product product = productRepository.getByIdProduct(productId);
        if (!client.getProductList().contains(product)) {
            System.out.println("Product with id = " + productId + " by client " + client.getName() + " " + client.getLastname() + " not found");
            return;
        }
        client.getProductList().remove(product);
    }
}
