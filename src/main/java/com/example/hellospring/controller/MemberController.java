package com.example.hellospring.controller;

import com.example.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller // 스프링이 실행될 때 이 어노테이션이 있다면, 스프링 컨테이너에 bean 객체로 넣어두고 관리함.
public class MemberController {

    // DI
    private final MemberService memberService;
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
