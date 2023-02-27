package com.daou.wiki.controller;

import com.daou.wiki.dto.MemberDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/*
 * 주로 리소스 값을 얻베이트 하는데 사용
 * */
@RestController
@RequestMapping("/api/v1/put-api")
public class PutController {

    /*
     * 서버에 어떤 값이 들어올지 모르는 경우에는 Map 객체를 활용해 값을 받을 수 있다.
     * 서버에 들어오는 요청에 담겨있는 값이 정해져 있는경우에는 DTO 객체를 활용
     * */
    @PutMapping("/member")
    public String postMember(@RequestBody Map<String, Object> putData) {
        StringBuilder sb = new StringBuilder();

        putData.forEach((key, value) -> {
            sb.append(key).append(" : ").append(value).append("\n");
        });

        return sb.toString();
    }

    @PutMapping(value = "/member1")
    public String postMemberDto1(@RequestBody MemberDto memberDto) {
        return memberDto.toString();
    }

    @PutMapping(value = "/member2")
    public MemberDto postMemberDto2(@RequestBody MemberDto memberDto) {
        return memberDto;
    }

    @PutMapping(value = "/member3")
    public ResponseEntity<MemberDto> postMemberDto3(@RequestBody MemberDto memberDto) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(memberDto);
    }

}
