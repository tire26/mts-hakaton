package ru.aston.recipes;

import ru.aston.buySystem.ComponentStorage;
import ru.aston.components.ComponentBase;
import ru.aston.components.Dough;
import ru.aston.components.Meat;

import java.util.List;

public class DoughWithMeat extends RecipesBase {
    public DoughWithMeat(ComponentBase component, ComponentBase component1) {
        super();
    }

    public static void makeDoughWithMeat(List<ComponentBase> componentList) {

        if (componentList.contains(new Dough()) && componentList.contains(new Meat())) {
            DoughWithMeat doughWithMeat = new DoughWithMeat(ComponentStorage.getComponent(Meat.class.getSimpleName()),
                    ComponentStorage.getComponent(Dough.class.getSimpleName()));
            System.out.println("Dough with meet is ready");
        }
    }
}
