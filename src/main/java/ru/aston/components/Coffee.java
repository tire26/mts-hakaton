package ru.aston.components;

import org.springframework.stereotype.Component;

@Component
public class Coffee extends ComponentBase{
    public Coffee() {
        timeToMake = 1;
    }

}
