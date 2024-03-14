package ru.aston.recipes;

import ru.aston.buySystem.ComponentStorage;
import ru.aston.components.ComponentBase;
import ru.aston.components.Dough;
import ru.aston.components.Fish;
import ru.aston.components.Meat;

import java.util.List;

public class PieWithFish extends RecipesBase {
    public PieWithFish(ComponentBase component, ComponentBase component1) {
        super();
    }

    public static void makePieWithFish(List<ComponentBase> componentList) {

        if (componentList.contains(new Dough()) && componentList.contains(new Fish())) {
            PieWithFish pieWithFish = new PieWithFish(ComponentStorage.getComponent(Fish.class.getSimpleName()),
                    ComponentStorage.getComponent(Dough.class.getSimpleName()));
            System.out.println("Pie with fish is ready");
        }
    }
}
