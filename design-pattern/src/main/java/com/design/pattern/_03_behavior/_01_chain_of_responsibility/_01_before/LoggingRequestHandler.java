package com.design.pattern._03_behavior._01_chain_of_responsibility._01_before;

public class LoggingRequestHandler extends RequestHandler{
    @Override
    public void handler(Request request) {
        System.out.println("로깅");
        super.handler(request);
    }
}
