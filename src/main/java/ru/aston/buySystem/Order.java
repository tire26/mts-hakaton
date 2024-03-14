package ru.aston.buySystem;

import ru.aston.components.ComponentBase;

public class Order {

    private ComponentBase component;
    private int count;

    public Order(ComponentBase component, int count) {
        this.component = component;
        this.count = count;
    }

    public ComponentBase getComponent() {
        return component;
    }

    public int getCount() {
        return count;
    }
}
