package ru.aston.recipes;

import ru.aston.buySystem.ComponentStorage;
import ru.aston.components.Carbagge;
import ru.aston.components.ComponentBase;
import ru.aston.components.Dough;

import java.util.List;

public class DoughWithCarbagge {
    public DoughWithCarbagge(ComponentBase component, ComponentBase component1) {
        super();
    }

    public static void makeDoughWithCarbagge(List<ComponentBase> componentList) {

        if (componentList.contains(new Dough()) && componentList.contains(new Carbagge())) {
            DoughWithCarbagge doughWithCarbagge = new DoughWithCarbagge(ComponentStorage.getComponent(Carbagge.class.getSimpleName()),
                    ComponentStorage.getComponent(Dough.class.getSimpleName()));
            System.out.println("Dough with carbagge is ready");
        }
    }
}
