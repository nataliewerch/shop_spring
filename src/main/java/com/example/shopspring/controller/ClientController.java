package com.example.shopspring.controller;

import com.example.shopspring.model.Client;
import com.example.shopspring.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<Client> getAll() {
        return clientService.getAll();
    }

    @GetMapping("/{id}")
    public Client getClient(@PathVariable(name = "id") int id) {
        return clientService.getById(id);
    }

    @PostMapping
    public Client create(@RequestBody Client client) {
        return clientService.save(client);
    }

    @PostMapping("/{clientId}/add/{productId}")
    public void addProductToBasket(@PathVariable(name = "clientId") int clientId, @PathVariable(name = "productId") int productId) {
        clientService.addProductToBasket(clientId, productId);
    }

    @DeleteMapping("/{clientId}/remove/{productId}")
    public void removeProductFromBasket(@PathVariable(name = "clientId") int clientId, @PathVariable(name = "productId") int productId) {
        clientService.removeProductFromBasket(clientId, productId);
    }
}
