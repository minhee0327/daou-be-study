package com.design.pattern._02_structure._03_composite._01_before;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Bag {

    private List<Item> items = new ArrayList<>();

    public void add(Item item) {
        items.add(item);
    }

    public List<Item> getItems() {
        return items;
    }
}
