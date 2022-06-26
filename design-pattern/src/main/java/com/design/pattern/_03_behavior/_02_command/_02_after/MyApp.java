package com.design.pattern._03_behavior._02_command._02_after;

import com.design.pattern._03_behavior._02_command._01_before.Game;
import com.design.pattern._03_behavior._02_command._01_before.Light;

public class MyApp {

    private Command command;

    public MyApp(Command command) {
        this.command = command;
    }

    public void press(){
        command.execute();
    }

    public static void main(String[] args) {
//        Button button = new Button(new GameStartCommand(new Game()));
        Button button = new Button();
        button.press(new GameStartCommand(new Game()));
        button.press(new GameStartCommand(new Game()));
    }
}
