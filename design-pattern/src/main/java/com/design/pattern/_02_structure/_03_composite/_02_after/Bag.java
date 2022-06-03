package com.design.pattern._02_structure._03_composite._02_after;

import java.util.ArrayList;
import java.util.List;

//Bag은 Composite 역할을 한다. => 따라서 Leaf가 아닌, component를 참조해야한다.
public class Bag implements Component{

    private List<Component> components = new ArrayList<>();

    public void add(Component component) {
        components.add(component);
    }

    public List<Component> getComponents() {
        return components;
    }

    //기존에 Client에 만들어두었었는데 이 책임을 이제 Bag이 지게 되는것
    @Override
    public int getPrice() {
        return components.stream().mapToInt(Component::getPrice).sum();
    }
}
