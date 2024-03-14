package ru.aston.delivery.service;

import org.springframework.stereotype.Service;
import ru.aston.delivery.model.City;
import ru.aston.delivery.model.Courier;
import ru.aston.delivery.model.DeliveryOrder;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Service
public class DeliveryServiceImpl implements DeliveryService {
    private Map<String, City> cities = new HashMap<>();
    private final ExecutorService executorService;

    public DeliveryServiceImpl() {
        cities.put("Москва", new City("Москва"));
        cities.put("Санкт-Петербург", new City("Санкт-Петербург"));
        cities.put("Новосибирск", new City("Новосибирск"));
        cities.put("Екатеринбург", new City("Екатеринбург"));
        executorService =  Executors.newFixedThreadPool(10* cities.values().size());
    }

    @Override
    public DeliveryOrder processDelivery(DeliveryOrder order) {
        String cityName = order.getCity();
        if (!cities.containsKey(cityName)) {
            throw new IllegalArgumentException("Заказ не может быть доставлен");
        }
        City city = cities.get(cityName);
        Future<DeliveryOrder> future = deliverOrderAsync(order, city.getCouriers());
        try {
            return future.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    private Future<DeliveryOrder> deliverOrderAsync(DeliveryOrder order, Courier[] couriers) {
        return executorService.submit(() -> {
            for (Courier courier : couriers) {
                if (courier.canDeliver(order)) {
                    courier.deliver(order);
                    return order;
                }
            }
            throw new IllegalArgumentException("Нет доступных курьеров");
        });
    }
}
