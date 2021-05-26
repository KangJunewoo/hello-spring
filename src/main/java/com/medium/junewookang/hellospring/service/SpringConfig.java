package com.medium.junewookang.hellospring.service;

import com.medium.junewookang.hellospring.repository.MemberRepository;
import com.medium.junewookang.hellospring.repository.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    // 컨트롤러는.. @Controller 달아줘야 한다.

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
