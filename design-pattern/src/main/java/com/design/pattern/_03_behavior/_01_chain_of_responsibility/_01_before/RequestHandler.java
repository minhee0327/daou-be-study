package com.design.pattern._03_behavior._01_chain_of_responsibility._01_before;

public class RequestHandler {
    public void handler(Request request) {
        System.out.println("인증이 되었나");
        System.out.println("이 핸들러를 사용할 수 있는 유저인가");
        System.out.println(request.getBody());
    }
}
