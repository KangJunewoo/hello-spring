package com.medium.junewookang.hellospring.controller;

import com.medium.junewookang.hellospring.domain.Member;
import com.medium.junewookang.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller // 빈으로 등록되어 스프링이 관리함.
public class MemberController {
//     private final MemberService memberService = new MemberService(); 이렇게 쓰는거보다는
//    @Autowired final MemberService memberService; -> 이러한 필드주입은 가능하긴 하지만 별로댜.

//    private MemberService memberService; -> 요런 세터주입도 가능하긴 하다고 함.
//    @Autowired
//    public void setMemberService(MemberService memberService){
//        this.memberService = memberService;
//    }

    // 가장 권장되는 스타일은 아래와 같이 생성자에 주입하는 것.
    private MemberService memberService;

    /**
     * 내가 memberService가 필요해서 원래 직접 객체를 만들려고 했는데
     * 오토와이어드를 사용해서 만들어진 걸 쓰도록 하겠어.
     * 스프링 빈으로 떠돌고 있는 걸 가져오겠다!
     */
    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member); // 회원가입 할 때 그 쪼인.

        return "redirect:/"; // 이런식으로 리다이렉션도 선언할 수 있구나.
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers(); // 서비스에서 구현한 함수로 싹 불러와서
        model.addAttribute("members", members); // members에 모델로 등록한 다음
        return "members/memberList"; // 뷰엔진아 부탁해!
    }
}
