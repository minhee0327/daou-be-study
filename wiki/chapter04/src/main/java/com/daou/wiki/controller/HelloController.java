package com.daou.wiki.controller;

import com.daou.wiki.service.HelloService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloController {

    private final HelloService helloService;

    @RequestMapping("/hello")
    public String hello(){
        return helloService.hello();
    }
}
