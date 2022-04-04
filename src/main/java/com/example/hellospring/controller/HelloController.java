package com.example.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    // 컨트롤러에서 리턴값으로 문자를 반환하면, View Resolver(뷰 리졸버)가 화면을 찾아서 처리함.
    // 스프링 부트 탬플릿 엔진 기본 viewName 매핑.
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "Hello World!!!");

        // 'resources:templates/' + {ViewName}==hello + '.html'
        return "hello";
    }
}
