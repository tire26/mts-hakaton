package ru.aston.recipes;

import ru.aston.buySystem.ComponentStorage;
import ru.aston.components.*;

import java.util.List;

public class RecipesCoffee extends RecipesBase {
    public RecipesCoffee(ComponentBase component) {
        super();
    }

    public static void makeCoffee(List<ComponentBase> componentList) {

        if (componentList.contains(new Coffee())) {
            RecipesCoffee coffee = new RecipesCoffee(ComponentStorage.getComponent(Coffee.class.getSimpleName()));
            System.out.println("Coffee is ready");
        }
    }
}
