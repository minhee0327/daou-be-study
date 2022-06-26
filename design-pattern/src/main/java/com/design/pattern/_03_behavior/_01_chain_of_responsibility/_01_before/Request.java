package com.design.pattern._03_behavior._01_chain_of_responsibility._01_before;

public class Request {
    private String body;

    public Request(String body) {
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
