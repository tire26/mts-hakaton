package ru.aston.orders.model;

import java.time.LocalDateTime;

public class Order {
    String product;
    int quantity;
    LocalDateTime dateTime;
    String deliveryType;
    String city;

    public Order(String product, int quantity, LocalDateTime dateTime, String deliveryType, String city) {
        this.product = product;
        this.quantity = quantity;
        this.dateTime = dateTime;
        this.deliveryType = deliveryType;
        this.city = city;
    }

    public String getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Заказ: " + quantity + " x " + product + ", Дата-время: " + dateTime + ", Тип доставки: " + deliveryType + ", Город: " + city;
    }
}
