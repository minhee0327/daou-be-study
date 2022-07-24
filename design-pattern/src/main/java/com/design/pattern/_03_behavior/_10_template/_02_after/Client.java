package com.design.pattern._03_behavior._10_template._02_after;

public class Client {

    public static void main(String[] args) {
        FileProcessor fileProcessor = new Multiply("number.txt");
        int result = fileProcessor.process(((sum, number) -> sum += number));
        System.out.println(result);
    }
}
