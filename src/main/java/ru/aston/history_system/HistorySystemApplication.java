package ru.aston.history_system;


import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Map;

public class HistorySystemApplication {
    private final Map<Integer, ClientOrderLog> clientOrderMap;
    private int clientOrderId = 1;
    private int rawOrderId = 1;
    private int deliverOrderId = 1;
    private final Map<Integer, DeliverOrderLog> deliverOrderMap;
    private final Map<Integer, RawOrderLog> rawOrderMap;

    public HistorySystemApplication(Map<Integer, ClientOrderLog> clientOrder, Map<Integer, DeliverOrderLog> deliverMap, Map<Integer, RawOrderLog> rawOrderMap) {
        this.clientOrderMap = clientOrder;
        this.deliverOrderMap = deliverMap;
        this.rawOrderMap = rawOrderMap;
    }

    /**
     * Создается лог заказа клиента
     * @param clientOrder заказ клиента
     */
    public void logClientOrder(ClientOrder clientOrder) {
        System.out.println("Создан лог для заказа клиента");
        ClientOrderLog clientOrderLog = new ClientOrderLog();
        clientOrderLog.setId(clientOrderId);
        clientOrderLog.setProductsList(clientOrder.getProducts());
        // принимать значение о том, что доставка выполнилась
        clientOrderLog.setDelivered(isOrderComplete());
        clientOrderLog.setCreatedAt(LocalDateTime.now());

        clientOrderMap.put(clientOrderId++, clientOrderLog);
    }

    /**
     * Создает лог заказа сырья
     * @param rawOrder заказ сырья
     */
    public void logRawOrder(RawOrder rawOrder) {
        System.out.println("Создан лог для заказа сырья");
        RawOrderLog rawOrderLog = new RawOrderLog();
        rawOrderLog.setId(rawOrderId);
        rawOrderLog.setRawType(rawOrder.getRawType());
        rawOrderLog.setCount(rawOrder.getCount());
        rawOrderLog.setCreatedAt(LocalDateTime.now());

        rawOrderMap.put(rawOrderId++, rawOrderLog);
    }


    /**
     * Создает лог доставки
     * @param deliverOrder доставка
     */
    public void logDeliverOrder(DeliverOrder deliverOrder) {
        System.out.println("Создан лог для доставки");
        DeliverOrderLog deliverOrderLog = new DeliverOrderLog();
        deliverOrderLog.setId(deliverOrderId);
        deliverOrderLog.setProductList(deliverOrder.getProducts());

        deliverOrderLog.setTimeForDelivering(deliverOrder.getFinishTime() - deliverOrder.getStartTime());

        deliverOrderMap.put(deliverOrderId++, deliverOrderLog);
    }

}
