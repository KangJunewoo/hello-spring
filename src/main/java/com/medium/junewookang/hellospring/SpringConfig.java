package com.medium.junewookang.hellospring;

import com.medium.junewookang.hellospring.repository.JpaMemberRepository;
import com.medium.junewookang.hellospring.repository.MemberRepository;
import com.medium.junewookang.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    // 컨트롤러는.. @Controller 달아줘야 한다.
    // 사실 서비스랑 리포지토리도 @Service, @Repository 달아주면 알아서 관리되긴 하지만
    // 여기선 그냥 시험삼아 여기서 아싸리 생성해서 빈에 넣어주는걸 보고 넘어가자.
    private final DataSource dataSource;
    private final EntityManager em;

    public SpringConfig(DataSource dataSource, EntityManager em){
        this.dataSource = dataSource;
        this.em = em;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
//        return new MemoryMemberRepository();
//        return new JpaMemberRepository(dataSource);
//        return new JdbcTemplateMemberRepository(dataSource);
        return new JpaMemberRepository(em);
    }
}
