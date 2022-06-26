package com.design.pattern._03_behavior._01_chain_of_responsibility._02_after;

import com.design.pattern._03_behavior._01_chain_of_responsibility._01_before.Request;

public abstract class RequestHandler {

    private RequestHandler nextHandler;

    public RequestHandler(RequestHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    //요청 처리를 다음 핸들러에 위임하는 방식
    public void handle(Request request){
        if(nextHandler != null){
            nextHandler.handle(request);
        }
    }
}
