package com.medium.junewookang.hellospring.service;

import com.medium.junewookang.hellospring.domain.Member;
import com.medium.junewookang.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService = new MemberService();
    MemoryMemberRepository memberRepository = new MemoryMemberRepository(); // 리포지토리 테스트에서 쓰는거랑 같은건데.. 같은 객체로 통일하면 안되나?
    // ctrl r 을 누르면 이전에 실행했던거 그대로 실행해줌.

    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }



    @Test
    void 회원가입() { // 테스트용은 걍 한글써도 무방. given, when, then 주석 달아놓고 시작하자.
        // given
        Member member = new Member();
        member.setName("hello");

        // when
        Long saveId = memberService.join(member);

        // then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    void 중복회원가입() { // 테스트용은 걍 한글써도 무방. given, when, then 주석 달아놓고 시작하자.
        // given
        Member member1 = new Member();
        member1.setName("hello");
        Member member2 = new Member();
        member2.setName("hello");

        // when
        memberService.join(member1);
//        try{
//            memberService.join(member2);
//            fail();
//        } catch(IllegalStateException e){
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        }
        // 위에걸 줄이면
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        //


        // then

    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}