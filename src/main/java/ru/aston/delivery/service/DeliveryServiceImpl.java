package ru.aston.delivery.service;

import ru.aston.delivery.model.Address;
import ru.aston.delivery.model.City;
import ru.aston.delivery.model.DeliveryOrder;

import java.util.HashMap;
import java.util.Map;

public class DeliveryServiceImpl implements DeliveryService {
    private Map<String, City> cities = new HashMap<>();

    public DeliveryServiceImpl() {
        cities.put("Москва", new City("Москва"));
        cities.put("Санкт-Петербург", new City("Санкт-Петербург"));
        cities.put("Новосибирск", new City("Новосибирск"));
        cities.put("Екатеринбург", new City("Екатеринбург"));
    }

    public DeliveryOrder processOrder(DeliveryOrder order, Address address) {
        String cityName = order.getCity();
        if (!cities.containsKey(cityName)) {
            throw new IllegalArgumentException("Заказ не может быть доставлен");
        }
        City city = cities.get(cityName);
        return city.deliverOrder(order);
    }

    @Override
    public String deliver(DeliveryOrder deliveryOrder, Address address) {
        return null;
    }
}
