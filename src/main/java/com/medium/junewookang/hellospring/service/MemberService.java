package com.medium.junewookang.hellospring.service;

import com.medium.junewookang.hellospring.domain.Member;
import com.medium.junewookang.hellospring.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService { // 서비스는 좀 더 비즈니스에 가까움.
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Long join(Member member){
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

















