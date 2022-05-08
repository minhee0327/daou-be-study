package com.design.pattern._01_createion._01_singleton;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringExample {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);

        String hello = applicationContext.getBean("hello", String.class);
        String hello1 = applicationContext.getBean("hello", String.class);

        //singleton scope (인스턴스를 application context 내부에서 싱글톤 스콥으로 관리)
        //싱글톤 패턴과는 엄밀히 말해서는 다름.
        System.out.println(hello == hello1);
    }
}
