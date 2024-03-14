package ru.aston.delivery.model;

import ru.aston.orders.model.Order;

public class Courier {

    private Integer speed;
    private Integer capacity;
    private int currentLoad;

    public Courier(int capacity, int speed) {
        this.capacity = capacity;
        this.speed = speed;
        this.currentLoad = 0;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public int getCurrentLoad() {
        return currentLoad;
    }

    public void setCurrentLoad(int currentLoad) {
        this.currentLoad = currentLoad;
    }

    public boolean canDeliver(Order order) {
        return currentLoad + order.getQuantity() <= capacity;
    }

    public void deliver(Order order) {
        currentLoad += order.getQuantity();
    }
}
