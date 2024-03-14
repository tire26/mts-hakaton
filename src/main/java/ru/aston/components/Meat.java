package ru.aston.components;

import org.springframework.stereotype.Component;

@Component
public class Meat extends ComponentBase{
    public Meat() {
        timeToMake = 1;
    }
}
