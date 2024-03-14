package ru.aston.history_system;

import java.time.LocalDateTime;
import java.util.List;

public class DeliverOrderLog {
    private Integer id;
    private List<Product> productList;
    private LocalDateTime timeForDelivering;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public LocalDateTime getTimeForDelivering() {
        return timeForDelivering;
    }

    public void setTimeForDelivering(LocalDateTime timeForDelivering) {
        this.timeForDelivering = timeForDelivering;
    }
}
