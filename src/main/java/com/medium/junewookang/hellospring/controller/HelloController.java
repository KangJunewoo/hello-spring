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
        model.addAttribute("data", "hello!!"); // 모델에 {"data":"hello!!"} 추가한 셈.
        return "hello"; // 뷰엔진아 templates/hello.html로 부탁해
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(name="name") String name, Model model){ // 쿼리스트링 name 받아서
        model.addAttribute("name", name); // name속성에 넣은담에
        return "hello-template";// 뷰엔진아 templates/hello-template.html로 부탁해
    }

    @GetMapping("hello-string")
    @ResponseBody // 뷰엔진 없이 생짜로 간다
    public String helloString(@RequestParam("name") String name){
        return "hello" + name;
    } // 말그대로 이 리턴값을 웹브라우저에 리턴.

    @GetMapping("hello-api")
    @ResponseBody // 뷰엔진 없이 생짜로 간다
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello; // 문자가 아닌 객체를 넘기면 알아서 json으로 변환됨.
    }

    static class Hello{ // 바로 위 helloApi 테스트하려고 임시로 만듦.
        private String name;
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }
}
