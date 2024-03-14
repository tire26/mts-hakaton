package ru.aston.buySystem;


import org.springframework.stereotype.Component;
import ru.aston.components.*;

import java.io.Console;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ComponentStorage {
    static Map<String, List<ComponentBase>> componentMap = new HashMap();

    public static void setComponentMap(Map<String, List<ComponentBase>> componentMap) {
        ComponentStorage.componentMap = componentMap;
    }

    public ComponentStorage() { // инициализировать сразу с 3 компонентами каждого типа
        componentMap.put(Berry.class.getSimpleName(), BuySystem.getComponents(new Order(new Berry(),6)));
        componentMap.put(Carbagge.class.getSimpleName(), BuySystem.getComponents(new Order(new Carbagge(),6)));
        componentMap.put(Coffee.class.getSimpleName(),BuySystem.getComponents(new Order(new Coffee(),6)));
        componentMap.put(Dough.class.getSimpleName(),BuySystem.getComponents(new Order(new Dough(),6)));
        componentMap.put(Fish.class.getSimpleName(),BuySystem.getComponents(new Order(new Fish(),6)));
        componentMap.put(Meat.class.getSimpleName(),BuySystem.getComponents(new Order(new Meat(),6)));
        componentMap.put(Tea.class.getSimpleName(),BuySystem.getComponents(new Order(new Tea(),6)));
    }

    public static void putComponentMap(ComponentBase componentBase) {
        componentMap.get(componentBase.getClass().getName()).add(componentBase);
    }

    private static void updateComponentPool(String componentClassName)
    {
        List<ComponentBase> bufList = new ArrayList<>();
        for(int i = 0; i < 10;i++)
        {
            bufList.add(componentMap.get(componentClassName).get(0));
        }
        try
        {
            Thread.sleep(componentMap.get(componentClassName).get(0).getTimeToMake());
        }
       catch (Exception e)
       {
           System.out.println("Ошибка потока");
       }
        componentMap.put(componentClassName,bufList);
    }

    private static List<ComponentBase> getNewList(String componentClassName)
    {
        List<ComponentBase> bufList = new ArrayList<>();
        for(int i = 1;i < componentMap.get(componentClassName).size();i++)
        {
            bufList.add(componentMap.get(componentClassName).get(i));
        }

        return bufList;
    }

    public static ComponentBase getComponent(String componentClassName) {
        if (componentMap.containsKey(componentClassName)) {
            if(componentMap.get(componentClassName).size() == 1) updateComponentPool(componentClassName);

            ComponentBase res = componentMap.get(componentClassName).get(0);

            componentMap.put(componentClassName,getNewList(componentClassName));

            return res;

        }
        else
        {
            throw new IllegalArgumentException();
        }

    }


}
