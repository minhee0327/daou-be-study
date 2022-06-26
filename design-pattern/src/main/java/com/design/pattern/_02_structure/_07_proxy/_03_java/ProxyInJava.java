package com.design.pattern._02_structure._07_proxy._03_java;

import com.design.pattern._02_structure._07_proxy._02_after.DefaultGameService;
import com.design.pattern._02_structure._07_proxy._02_after.GameService;

import java.lang.reflect.Proxy;

public class ProxyInJava {

    public static void main(String[] args) throws InterruptedException {
        ProxyInJava proxyInJava = new ProxyInJava();
        proxyInJava.dynamicProxy();
    }

    private void dynamicProxy() throws InterruptedException {
        GameService gameServiceProxy = getGameServiceProxy(new DefaultGameService());
        gameServiceProxy.startGame();
    }

    private GameService getGameServiceProxy(GameService target) {
        return  (GameService) Proxy.newProxyInstance(this.getClass().getClassLoader(),
                new Class[]{GameService.class}, (proxy, method, args) -> {
                    System.out.println("O");
                    //method.invoke 실행전 진행하고싶은 내용 추가
                    method.invoke(target, args);
                    //method.invoke 실행후 진행하고 싶은 내용추가
                    System.out.println("ㅁ");
                    return null;
                });
    }
}
