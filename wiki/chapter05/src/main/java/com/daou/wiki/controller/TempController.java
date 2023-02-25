package com.daou.wiki.controller;

import com.daou.wiki.service.HelloService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TempController {

    private final HelloService helloService;

    @GetMapping("/temp")
    public String temp(){
        return helloService.hello();
    }
}
