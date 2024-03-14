package ru.aston.delivery.service;

import org.springframework.stereotype.Service;
import ru.aston.delivery.model.City;
import ru.aston.delivery.model.Courier;
import ru.aston.orders.model.Order;

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
        executorService = Executors.newFixedThreadPool(10 * cities.values().size());
    }

    @Override
    public Order processDelivery(Order order) {
        String cityName = order.getCity();
        if (!cities.containsKey(cityName)) {
            throw new IllegalArgumentException("Заказ не может быть доставлен");
        }
        City city = cities.get(cityName);
        Future<Order> future = deliverOrderAsync(order, city.getCouriers());
        try {
            return future.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    private Future<Order> deliverOrderAsync(Order order, Courier[] couriers) {
        return executorService.submit(() -> {
            for (Courier courier : couriers) {
                if (courier.canDeliver(order)) {
                    courier.deliver(order);
                    Thread.sleep(courier.getCapacity() * 1000);
                    courier.setCapacity(courier.getCapacity() - 1);
                    return order;
                }
            }
            throw new IllegalArgumentException("Нет доступных курьеров");
        });
    }
}
