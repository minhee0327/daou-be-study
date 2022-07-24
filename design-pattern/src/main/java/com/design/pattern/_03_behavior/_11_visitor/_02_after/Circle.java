package com.design.pattern._03_behavior._11_visitor._02_after;

public class Circle implements Shape {

    @Override
    public void accept(Device device) {
        device.print(this);
    }
}
