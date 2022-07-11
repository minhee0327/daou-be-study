package com.design.pattern._03_behavior._07_observer._02_after;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Subject
public class ChatServer {

    private Map<String, List<Subscriber>> subscribers = new HashMap<>();

    public void register(String subject, Subscriber subscriber) {
        if (!subscribers.containsKey(subject)) {
            subscribers.put(subject, new ArrayList<>());
        }
        subscribers.get(subject).add(subscriber);
    }

    public void unregister(String subject, Subscriber subscriber) {
        if (subscribers.containsKey(subject)) {
            subscribers.get(subject).remove(subscriber);
        }
    }

    //여러 subscriber들에 상태 전달
    public void sendMessage(User user, String subject, String message) {
        if (this.subscribers.containsKey(subject)) {
            //이름을 여기서 받아서 사용할게 아닌거같음;
            String userMessage = user.getName() + " : " + message;
            this.subscribers.get(subject).forEach(s -> s.handleMessage(userMessage));
        }
    }
}
