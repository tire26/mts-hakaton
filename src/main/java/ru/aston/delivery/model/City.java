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

    public String getName() {
        return name;
    }

    public Courier[] getCouriers() {
        return couriers;
    }
}
