package com.design.pattern._02_structure._07_proxy._01_before;

public class GameService {
    public void startGame() throws InterruptedException {
        System.out.println("이 자리에 오신 여러분 환영합니다.");
        Thread.sleep(1000L);
    }
}
