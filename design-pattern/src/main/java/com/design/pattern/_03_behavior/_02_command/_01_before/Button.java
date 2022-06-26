package com.design.pattern._03_behavior._02_command._01_before;

public class Button {
    private Light light;

    public Button(Light light) {
        this.light = light;
    }

    public void press(){
        light.off();
    }

    public static void main(String[] args) {
        Button button = new Button(new Light());
        button.press();
        button.press();
        button.press();
        button.press();
    }
}
