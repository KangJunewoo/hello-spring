package com.medium.junewookang.hellospring.controller;

import com.medium.junewookang.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller // 빈으로 등록되어 스프링이 관리함.
public class MemberController {
    // private final MemberService memberService = new MemberService(); 이렇게 쓰는거보다는
    private final MemberService memberService;

    @Autowired // 스프링 컨테이너에서 가져오는 Service를 넣어주겠다.
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }
}
