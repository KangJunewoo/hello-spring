package com.medium.junewookang.hellospring.service;

import com.medium.junewookang.hellospring.domain.Member;
import com.medium.junewookang.hellospring.repository.MemberRepository;
import com.medium.junewookang.hellospring.repository.MemoryMemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// 순수한 자바 클래스로, 스프링이 이 아이를 알 방법이 없음.
// 그래서 쓰는 annotation이...

public class MemberService { // 서비스는 좀 더 비즈니스에 가까움.
    // cmd shift t로 바~로 테스트 생성
    // 테스트는 잘되는경우보다 예외상황이 훨~~~ 씬 중요함!
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원 가입
     * */
    public Long join(Member member){
        // 같은 이름의 중복 회원은 안됨
//        Optional<Member> result = memberRepository.findByName(member.getName()); // cmd opt v로 자동으로 저장될 곳 생성
//        result.ifPresent(m->{
//            throw new IllegalStateException("이미 존재하는 회원입니다.");
//        });
        validateDuplicateMember(member); // ctrl t 로 함수로 뽑아내기
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}

















