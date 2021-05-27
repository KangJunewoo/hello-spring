package com.medium.junewookang.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/") // 우선순위는 컨트롤러 > static
    public String home(){
        return "home";
    }
}
