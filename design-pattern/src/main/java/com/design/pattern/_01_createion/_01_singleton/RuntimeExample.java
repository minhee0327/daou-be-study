package com.design.pattern._01_createion._01_singleton;

public class RuntimeExample {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();

        System.out.println(runtime.maxMemory());
        System.out.println(runtime.freeMemory());
    }
}
