package com.design.pattern._02_structure._07_proxy._02_after;

public class GameServiceProxy implements GameService {

    private GameService gameService;

    public GameServiceProxy(GameService gameService) {
        this.gameService = gameService;
    }

    @Override
    public void startGame() throws InterruptedException {
        long before = System.currentTimeMillis();
        //권한체크를 할 수도 있고, return 값을 변경할 수도 있다.
        gameService.startGame();
        System.out.println(System.currentTimeMillis() - before);
    }
}
