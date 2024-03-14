package ru.aston.delivery.service;

import ru.aston.orders.model.Order;

public interface DeliveryService {
    Order processDelivery(Order order);
}
