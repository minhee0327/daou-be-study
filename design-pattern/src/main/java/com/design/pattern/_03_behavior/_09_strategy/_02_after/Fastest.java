package com.design.pattern._03_behavior._09_strategy._02_after;

public class Fastest implements Speed{
    @Override
    public void blueLight() {
        System.out.println("무궁화꼬치");
    }

    @Override
    public void redLight() {
        System.out.println("피었씀다.");
    }
}
