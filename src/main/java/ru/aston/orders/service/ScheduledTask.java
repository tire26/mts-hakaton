package ru.aston.orders.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.aston.buySystem.ComponentStorage;
import ru.aston.components.Tea;
import ru.aston.delivery.service.DeliveryService;
import ru.aston.orders.model.Order;
import ru.aston.recipes.RecipesBase;
import ru.aston.recipes.RecipesTea;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
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
                deliveryService.processDelivery(newOrder);
            } else if (newOrder.getDeliveryType().matches("у кассы")) {

            }
            System.out.println("Новый заказ добавлен в очередь: " + newOrder);
        }
    }

    private static Order generateRandomOrder() {
        RecipesBase product = RecipesTea.makeTea(List.of(ComponentStorage.getComponent(Tea.class.getSimpleName())));
        int quantity = random.nextInt(3) + 1;
        LocalDateTime dateTime = LocalDateTime.now();
        String deliveryType = random.nextBoolean() ? "курьер" : "у кассы";
        String city = random.nextBoolean() ? "Москва" : "Санкт-Петербург";

        return new Order(product, quantity, dateTime, deliveryType, city);
    }
}
