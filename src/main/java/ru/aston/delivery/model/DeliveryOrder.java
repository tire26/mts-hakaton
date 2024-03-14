package ru.aston.delivery.model;

public class DeliveryOrder {

    private String city;
    private int products;

    public DeliveryOrder(String city, int products) {
        this.city = city;
        this.products = products;
    }

    public String getCity() {
        return city;
    }

    public int getProducts() {
        return products;
    }
}
