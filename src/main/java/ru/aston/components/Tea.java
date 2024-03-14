package ru.aston.components;


import org.springframework.stereotype.Component;

@Component
public class Tea extends ComponentBase{

    public Tea() {
        timeToMake = 1;
    }
}
