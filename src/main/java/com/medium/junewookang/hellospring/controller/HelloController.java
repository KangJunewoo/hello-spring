package com.medium.junewookang.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(name="name") String name, Model model){ // 커맨드피 꿀팁
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody // 음 뷰엔진 없이 스트링이나 json 리턴할땐 요 어노테이션. 거의 api에 쓰이긴함.
    public String helloString(@RequestParam("name") String name){
        return "hello" + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello(); // 커맨드쉬프트엔터 귀찮은부분 자동완성 미쳤다.
        hello.setName(name);
        return hello; // 문자가 아닌 객체를 넘긴다면? -> json 방식으로 넘기게 됨.
    }

    static class Hello{ // 객체만들려고 임시로 걍 만든거.
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
