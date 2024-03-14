package ru.aston.orders.model;

import ru.aston.recipes.RecipesBase;

import java.time.LocalDateTime;

public class Order {
    RecipesBase product;
    int quantity;
    LocalDateTime dateTime;
    String deliveryType;
    String city;

    public Order(RecipesBase product, int quantity, LocalDateTime dateTime, String deliveryType, String city) {
        this.product = product;
        this.quantity = quantity;
        this.dateTime = dateTime;
        this.deliveryType = deliveryType;
        this.city = city;
    }

    public RecipesBase getProduct() {
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
