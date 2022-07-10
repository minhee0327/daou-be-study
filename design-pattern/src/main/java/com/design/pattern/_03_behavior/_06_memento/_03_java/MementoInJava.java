package com.design.pattern._03_behavior._06_memento._03_java;


import com.design.pattern._03_behavior._06_memento._01_before.Game;

import java.io.*;
import java.util.Date;

public class MementoInJava {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //TODO: Date
        Date date = new Date();
        System.out.println(date);
        long time = date.getTime();
        date.setTime(time);

        //TODO: Serializable (obj -> byte stream)
        Game game = new Game();
        game.setBlueTeamScore(10);
        game.setBlueTeamScore(20);
        try (FileOutputStream fileOutput = new FileOutputStream("GameSave.hex");
             ObjectOutputStream out = new ObjectOutputStream(fileOutput))
        {
            out.writeObject(game);
        }
        game.setBlueTeamScore(25);
        game.setBlueTeamScore(15);

        //TODO: 역직렬화 (byte -> object)
        try(FileInputStream fileIn = new FileInputStream("GameSave.hex");
            ObjectInputStream in = new ObjectInputStream(fileIn))
        {
            game = (Game) in.readObject();
            System.out.println(game.getBlueTeamScore());
            System.out.println(game.getRedTeamScore());

        }
    }
}
