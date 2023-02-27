package com.daou.wiki.controller;

import org.springframework.web.bind.annotation.*;

/*
 * 데이터베이스 등의 저장소에 있는 리소스를 삭제할 때 사용한다.
 * 클라이언트에서 리소스를 식별할 수 있는 값을 받아서 db 나 캐시에있는 리소스를 조회하고 삭제하는 역할을 수행한다.
 * */
@RestController
@RequestMapping("/api/v1/delete-api")
public class DeleteController {

    /*
     * @PathVariable 과 @RequestParam 을 확용한 delete 메서드 구현
     * */
    @DeleteMapping(value = "/{variable}")
    public String DeleteVariable(@PathVariable String variable) {
        return variable;
    }

    @DeleteMapping(value = "/request1")
    public String DeleteVariable2(@RequestParam String email) {
        return "e-mail: " + email;
    }

}
