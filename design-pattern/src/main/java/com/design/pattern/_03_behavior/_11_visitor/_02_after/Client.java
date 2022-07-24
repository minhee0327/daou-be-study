package com.design.pattern._03_behavior._11_visitor._02_after;

public class Client {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle();
        Device device = new Phone();
        rectangle.accept(device);
    }
}
