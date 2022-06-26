package com.design.pattern._03_behavior._02_command._02_after;

//뭔가를 실행하는 반환타입이 없는 메서드만 정의하고 있다. (Runnable 과 비슷)
public interface Command {
    void execute();

    void undo();
}
