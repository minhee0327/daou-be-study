package com.design.pattern._03_behavior._06_memento._02_after;

import com.design.pattern._03_behavior._06_memento._01_before.Game;

public class Client {
    public static void main(String[] args) {
        Game game = new Game();
        game.setBlueTeamScore(10);
        game.setRedTeamScore(20);

        GameSave gameSave = game.save();

        game.setBlueTeamScore(12);
        game.setRedTeamScore(22);

        game.restore(gameSave);
        System.out.println(game.getBlueTeamScore());
        System.out.println(game.getRedTeamScore());
    }
}
