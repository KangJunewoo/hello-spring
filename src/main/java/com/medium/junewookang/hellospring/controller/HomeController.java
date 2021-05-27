package com.medium.junewookang.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/") // 이런 식으로 / 있으면 static에 있는거 무시됨.
    public String home(){
        return "home";
    }
}
