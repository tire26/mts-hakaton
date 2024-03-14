package ru.aston.delivery.model;

public class City {

    private String name;
    public City(String name) {
        this.name = name;
    }

    private final Courier[] couriers = {
            new Courier(20, 1),
            new Courier(10, 2),
            new Courier(5, 3)
    };

    public DeliveryOrder deliverOrder(DeliveryOrder order) {
        for (Courier courier : couriers) {
            if (courier.canDeliver(order)) {
                courier.deliver(order);
                return order;
            }
        }
        throw new IllegalArgumentException("Нет доступных курьеров");
    }
}
