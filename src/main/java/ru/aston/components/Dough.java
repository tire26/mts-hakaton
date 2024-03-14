package ru.aston.components;

import org.springframework.stereotype.Component;

@Component
public class Dough extends ComponentBase{
    public Dough() {
        timeToMake = 1;
    }
}
