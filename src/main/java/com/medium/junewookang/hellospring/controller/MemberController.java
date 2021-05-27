package com.medium.junewookang.hellospring.controller;

import com.medium.junewookang.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller // 빈으로 등록되어 스프링이 관리함.
public class MemberController {
    // private final MemberService memberService = new MemberService(); 이렇게 쓰는거보다는
//    @Autowired final MemberService memberService; -> 이러한 필드주입은 가능하긴 하지만 별로댜.

//    private MemberService memberService; -> 요런 세터주입도 가능하긴 하다고 함.
//    @Autowired
//    public void setMemberService(MemberService memberService){
//        this.memberService = memberService;
//    }

    // 가장 권장되는 스타일은 생성자 주입.
    private MemberService memberService;

    @Autowired // 스프링 컨테이너에서 가져오는 Service를 넣어주겠다.
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }
}
