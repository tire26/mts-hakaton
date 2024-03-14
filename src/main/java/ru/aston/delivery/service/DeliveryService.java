package ru.aston.delivery.service;

import ru.aston.delivery.model.Address;
import ru.aston.delivery.model.DeliveryOrder;

public interface DeliveryService {
    String deliver(DeliveryOrder deliveryOrder, Address address);
}
