package com.daou.wiki.controller;

import com.daou.wiki.dto.MemberDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {

    private final Logger LOGGER = LoggerFactory.getLogger(GetController.class);

    //RequestMapping 에서 GET 메서드를 사용하는 방뻡
    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String getHello() {
        LOGGER.info("getHello 메서드가 호출되었습니다.");
        return "Hello world";
    }

    //5.2.2 매개변수가 없는 GET 메서드 구현
    @GetMapping(value = "/name")
    public String getName() {
        LOGGER.info("getName 메서드가 호출되었습니다.");
        return "Flature";
    }

    //5.2.3 @PathVariable 을 활용한 GET 메서드 구현
    //웹통신의 기본목적은 데이터를 주고받는 것이므로 매개변수를 받는 메서드를 작성하게됨
    //중괄호안의 변수명과 괄호의 변수명을 동일하게 맞추기. 맞추기 어렵다면 @PathVariable 괄호안에 변수명을 지정하기
    @GetMapping(value = "/variable1/{variable}")
    public String getVariable1(@PathVariable String variable) {
        LOGGER.info("@PathVariable 을 통해서 들어온 값: {}", variable);
        return variable;
    }

    //PathVariable 의 value 는 생략 가능
    @GetMapping(value = "/variable2/{variable}")
    public String getVariable2(@PathVariable(value = "variable") String var) {
        return var;
    }

    //5.2.4 @RequestParam 을 활용한 GET 메서드 구현
    @GetMapping(value = "/request1")
    @Operation(summary = "GET 메서드 예제", description = "@RequestParam 을 활용한 GET Method")
    public String getRequestParam(
            @Parameter(description = "이름", required = true) @RequestParam String name,
            @Parameter(description = "이메일", required = true) @RequestParam String email,
            @Parameter(description = "회사", required = true) @RequestParam String organization) {
        return name + " " + email + " " + organization;
    }

    //쿼리스트링에 어떤 값이 들어올지 모른다면 Map 객체를 활용할 수도 있다.
    @GetMapping(value = "/request2")
    public String getRequestParam2(@RequestParam Map<String, String> param) {
        StringBuilder sb = new StringBuilder();

        param.entrySet().forEach(map -> {
            sb.append(map.getKey()).append(" : ").append(map.getValue()).append("\n");
        });

        return sb.toString();
    }

    //5.2.5 DTO 객체를 활용한 GET 메서드 구현
    //파라미터가 많을 경우 활용하여 가독성을 높일 수 있다.
    //http:localhost:8085/api/v1/get-api/request3?name=value&email=value2&organization=value3
    @GetMapping(value = "/request3")
    public String getRequestParam3(MemberDto memberDto) {
        return memberDto.toString();
    }

}
