package com.design.pattern._03_behavior._11_visitor._01_before;

public class Client {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle();
        rectangle.printTo(new Phone());
    }
}
