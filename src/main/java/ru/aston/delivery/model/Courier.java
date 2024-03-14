package ru.aston.delivery.model;

public class Courier {

    private Integer speed;
    private Integer capacity;
    private int currentLoad;

    public Courier(int capacity, int speed) {
        this.capacity = capacity;
        this.speed = speed;
        this.currentLoad = 0;
    }

    public boolean canDeliver(DeliveryOrder order) {
        return currentLoad + order.getProducts() <= capacity;
    }

    public void deliver(DeliveryOrder order) {
        currentLoad += order.getProducts();
        // Here you can add logic to calculate delivery time based on speed
    }
}
