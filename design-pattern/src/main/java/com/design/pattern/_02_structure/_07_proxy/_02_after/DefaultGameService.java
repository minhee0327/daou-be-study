package com.design.pattern._02_structure._07_proxy._02_after;

public class DefaultGameService implements GameService{
    @Override
    public void startGame() throws InterruptedException {
        System.out.println("이 자리에 오신 여러분 환영합니다.");
        Thread.sleep(1000L);
    }
}
