package com.design.pattern._03_behavior._02_command._02_after;

import com.design.pattern._03_behavior._02_command._01_before.Game;

public class GameEndCommand implements Command{

    private Game game;

    public GameEndCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        game.end();
    }

    @Override
    public void undo() {
        new GameStartCommand(this.game).execute();
    }
}
