package com.design.pattern._03_behavior._07_observer._03_java;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MyEventListener implements ApplicationListener<MyEvent> {

    @EventListener(MyEvent.class)
//    @Override
    public void onApplicationEvent(MyEvent event) {
        System.out.println(event.getSource());
        System.out.println(event.getMessage());
    }
}
