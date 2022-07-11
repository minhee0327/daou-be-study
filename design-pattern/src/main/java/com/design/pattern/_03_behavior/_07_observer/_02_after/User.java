package com.design.pattern._03_behavior._07_observer._02_after;

//concrete observer
public class User implements Subscriber{

    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void handleMessage(String message) {
        System.out.println(message);
    }
}
