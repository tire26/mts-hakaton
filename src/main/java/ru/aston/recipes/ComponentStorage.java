package ru.aston.recipes;

public class ComponentStorage {
    static Map<String, List<ComponentBase>> componentMap = new HashMap();

    public static void setComponentMap(Map<String, List<ComponentBase>> componentMap) {
        ComponentStorage.componentMap = componentMap;
    }

    public  ComponentStorage() { // инициализировать сразу с 3 компонентами каждого типа
        componentMap.put(Component1.class.getSimpleName(),List.of(new Component1(),new Component1(),new Component1()));
        componentMap.put(Component2.class.getSimpleName(),List.of(new Component2(),new Component2(),new Component2()));
        componentMap.put(Component3.class.getSimpleName(),List.of(new Component3(),new Component3(),new Component3()));
        componentMap.put(Component4.class.getSimpleName(),List.of(new Component4(),new Component4(),new Component4()));

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

            ComponentBase res = componentMap.get(componentClassName).getFirst();

            componentMap.put(componentClassName,getNewList(componentClassName));

            return res;

        }
        else
        {
            throw new IllegalArgumentException();
        }

    }


}
