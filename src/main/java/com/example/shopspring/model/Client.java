package com.example.shopspring.model;

public class Client {
    private int id;
    private String name;
    private String lastname;
    private Basket basket;

    public Client(int id, String name, String lastname) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.basket = new Basket();

    }

    public Client() {
        //
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", basket=" + basket +
                '}';
    }
}
