package com.daou.wiki.controller;

import com.daou.wiki.dto.MemberDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/*
 * POST API 는 웹 어플리케이션을 통해 데이터 베이스 등의 저장소에 리소스를 저장할 때 사용하는 API
 * GET API: path(경로), param(파라미터)에 변수를 다망 요청을 보냈지만
 * POST API 에서는 저장하고자 하는 리소스나 값을 바디에 담아 서버에 전달한다. (uri 가 get api에 비해 간단)
 * */
@RestController
@RequestMapping("/api/v1/post-api")
public class PostController {
    @RequestMapping(value = "/domain", method = RequestMethod.POST)
    public String postExample() {
        return "Hello Post API";
    }

    /*
     * 일반적으로 클라이언트의 요청 트래픽에 값이 포함돼 있다.
     * HTTP BODY 에 값을 넣어 전송한다.
     * 예 JSON => {"name": "mini", "email": "leefree3@naver.com", "organization": "daou"}
     * @RequestBody: HTTP 의 Body 내용을 해당 어노테이션이 지정된 객체에 매핑하는 역할
     * 맵객체는 요청을 통해 어떤 값이 들어오게 될지 특정하기 어려울 때 주로 사용한다.
     * */
    @PostMapping("/member")
    public String postMember(@RequestBody Map<String, Object> postData) {
        StringBuilder sb = new StringBuilder();

        postData.forEach((key, value) -> sb.append(key).append(" : ").append(value).append("\n"));

        return sb.toString();
    }

    //요청 메시지에 들어갈 값이 정해져 있을때는 DTO객체를 매개변수로 삼아 작성할 수 있다.
    @PostMapping(value = "/member2")
    public String postMemberDto(@RequestBody MemberDto memberDto) {
        return memberDto.toString();
    }
}
