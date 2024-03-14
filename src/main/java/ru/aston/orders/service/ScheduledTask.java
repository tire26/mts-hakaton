package ru.aston.orders.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.aston.delivery.service.DeliveryService;
import ru.aston.orders.model.Order;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

@Component
public class ScheduledTask {

    private static final Queue<Order> orderQueue = new LinkedList<>();
    private static Random random = new Random();
    private DeliveryService deliveryService;

    public ScheduledTask(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @Scheduled(fixedDelay = 3000)
    public void task() {
        if (orderQueue.size() < 3) {
            Order newOrder = generateRandomOrder();
            orderQueue.offer(newOrder);
            if (newOrder.getDeliveryType().matches("куреьр")) {
                Order order = deliveryService.processDelivery(newOrder);
            } else if (newOrder.getDeliveryType().matches("у кассы")) {

            }
            System.out.println("Новый заказ добавлен в очередь: " + newOrder);
        }
    }

    private static Order generateRandomOrder() {
        String[] products = {"пирожок", "пирог", "чай", "кофе"};
        String product = products[random.nextInt(products.length)];
        int quantity = random.nextInt(3) + 1;
        LocalDateTime dateTime = LocalDateTime.now();
        String deliveryType = random.nextBoolean() ? "курьер" : "у кассы";
        String city = random.nextBoolean() ? "Москва" : "Санкт-Петербург";

        return new Order(product, quantity, dateTime, deliveryType, city);
    }
}
