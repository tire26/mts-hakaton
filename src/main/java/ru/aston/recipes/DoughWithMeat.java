package ru.aston.recipes;

import ru.aston.components.ComponentBase;
import ru.aston.components.Dough;
import ru.aston.components.Meat;

import java.util.List;

public class DoughWithMeat extends RecipesBase {
    public DoughWithMeat(List<ComponentBase> componentList) {
    }

    public static String makeDoughWithMeet(List<ComponentBase> componentList) {

        if (componentList.contains(new Dough()) && componentList.contains(new Meat())) {
            DoughWithMeat doughWithMeet = new DoughWithMeat();
            System.out.println("Dough with meet is ready");
        }
    }
}
