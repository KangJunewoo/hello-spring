package com.medium.junewookang.hellospring;


import com.medium.junewookang.hellospring.repository.JpaMemberRepository;
import com.medium.junewookang.hellospring.repository.MemberRepository;
import com.medium.junewookang.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import javax.persistence.EntityManager;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }
}
