package ru.aston.recipes;

import ru.aston.buySystem.ComponentStorage;
import ru.aston.components.Coffee;
import ru.aston.components.ComponentBase;
import ru.aston.components.Tea;

import java.util.List;

public class RecipesTea extends RecipesBase {
    public RecipesTea(ComponentBase component) {
        super();
    }

    public static RecipesTea makeTea(List<ComponentBase> componentList) {

        if (componentList.contains(new Tea())) {
            RecipesTea tea = new RecipesTea(ComponentStorage.getComponent(Tea.class.getSimpleName()));
            System.out.println("Tea is ready");
            return tea;
        }
        return null;
    }
}
