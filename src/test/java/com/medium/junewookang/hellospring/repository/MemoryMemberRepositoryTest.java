package com.medium.junewookang.hellospring.repository;

import com.medium.junewookang.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {
    // 테스트 순서는 보장이 되지 않는다.
    MemoryMemberRepository repository = new MemoryMemberRepository();

    // 테스트가 끝날때마다 깔끔하게 지워줘야 함. 테스트는 모든게 독립적이어야 하기 때문.
    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");
        repository.save(member);
        Member result = repository.findById(member.getId()).get();
        System.out.println("result = " + (result == member));
        assertThat(member).isEqualTo(result); // jupiter vs assertj.. 후자가 좀 더 편하다고 한다. static import도 꿀팁.
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member(); // 복붙 후 쉬프트f6..
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member(); // 복붙 후 쉬프트f6..
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }
}
