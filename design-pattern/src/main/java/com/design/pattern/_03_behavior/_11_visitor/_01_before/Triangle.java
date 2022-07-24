package com.design.pattern._03_behavior._11_visitor._01_before;

public class Triangle implements Shape{

    @Override
    public void printTo(Device device) {
        if(device instanceof Phone){
            System.out.println("print Rectangle to phone");
        }else if(device instanceof Watch){
            System.out.println("print Rectangle to watch");
        }
    }

}
