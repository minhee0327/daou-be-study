package com.design.pattern._03_behavior._07_observer._01_before;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        ChatServer chatServer = new ChatServer();

        User user1 = new User(chatServer);
        user1.sendMessage("디자인패턴", "이번엔 옵저버 패턴입니다.");
        user1.sendMessage("올드컵2021", "LCK 화이팅!");

        User user2 = new User(chatServer);
        System.out.println(user2.getMessage("디자인패턴"));

        user1.sendMessage("디자인패턴", "예제코드 보는중 ...");
        System.out.println(user2.getMessage("디자인패턴"));

    }
}
