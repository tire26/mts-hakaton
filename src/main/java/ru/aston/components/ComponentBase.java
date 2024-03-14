package ru.aston.components;

import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ComponentBase implements ComponentInt {

    int timeToMake;

    public int getTimeToMake() {
        return timeToMake;
    }

    @Override
    public boolean equals(Object obj) {
        return this.getClass().getSimpleName().equals(obj.getClass().getSimpleName());
    }

    @Override
    public int hashCode() {

        return Objects.hash(this.getClass().getSimpleName());
    }
}
