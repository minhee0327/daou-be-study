package com.design.pattern._03_behavior._09_strategy._02_after;

public class BlueLightRedLight {

    private Speed speed;

/*
    public BlueLightRedLight(Speed speed) {
        this.speed = speed;
    }
*/

    public void blueLight(Speed speed){
        speed.blueLight();
    }

    public void redLight(Speed speed){
        speed.redLight();
    }
}
