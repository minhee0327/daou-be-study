package com.design.pattern._03_behavior._01_chain_of_responsibility._02_after;

import com.design.pattern._03_behavior._01_chain_of_responsibility._01_before.Request;

public class AuthRequestHandler extends RequestHandler{

    public AuthRequestHandler(RequestHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handle(Request request) {
        System.out.println("인증이 되었는가?");
        super.handle(request);
    }
}
