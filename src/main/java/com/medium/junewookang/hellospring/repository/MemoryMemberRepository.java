package com.medium.junewookang.hellospring.repository;

import com.medium.junewookang.hellospring.domain.Member;

import java.util.*;


/**
 * 인터페이스 기반으로, 아직 DB가 정해지지 않았으니
 * 메모리상에 저장할 수 있는 리포지토리 구현.
 * DB 실제로 도입한다면 또 다른 Repository를 구현할듯.
 */
public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>(); // {1:Member1, 2:Member2, ...}, 임시DB정도.
    private static long sequence = 0L; // 순서

    @Override // (뜬금이지만) 인터페이스 확장시 override 선언해주는거 잊지말자.
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) { // 리포지토리에선 트라이캐치 대신 optional로 리턴해주는구나. 서비스에서 예외처리 해줄려나?
        return Optional.ofNullable(store.get(id)); // ofNullable로 감싸주면 null값이어도 오류없이 반환 가능.
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
