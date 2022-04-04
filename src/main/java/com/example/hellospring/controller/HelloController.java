package com.example.hellospring.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(name = "name", required = false) String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    // 데이터 입력받아서 호출
    @GetMapping("hello-string")
    @ResponseBody // http body에 데이터를 넣어주겠다는 의미
    public String helloString(@RequestParam("name") String name){
        return "hello " + name;
    }

    // json 형식으로 데이터를 입력받아 호출
    // API
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    @Data // getter & setter 자동 생성. >> 프로퍼티 방식
    static class Hello {
        private String name;

    }
}
