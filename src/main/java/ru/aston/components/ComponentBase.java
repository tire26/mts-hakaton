package ru.aston.components;

import java.util.Objects;

public class ComponentBase implements Component{

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
