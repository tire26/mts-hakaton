package ru.aston.delivery.service;

import ru.aston.delivery.model.DeliveryOrder;

public interface DeliveryService {
    DeliveryOrder processDelivery(DeliveryOrder order);
}
