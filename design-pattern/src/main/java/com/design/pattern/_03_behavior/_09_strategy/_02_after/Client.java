package com.design.pattern._03_behavior._09_strategy._02_after;

public class Client {
    public static void main(String[] args) {
        BlueLightRedLight game = new BlueLightRedLight();

        game.blueLight(new Normal());
        game.redLight(new Faster());
        game.blueLight(new Speed() {//익명 클래스
            @Override
            public void blueLight() {
                System.out.println("blue Light");
            }

            @Override
            public void redLight() {
                System.out.println("red Light");
            }
        });
    }
}
