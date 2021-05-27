package com.medium.junewookang.hellospring.repository;

import com.medium.junewookang.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * 리포지토리엔 최소한 아래 로직들이 들어가야 하는데
 * 아직 DB가 정해지지 않았으니
 * 급한대로 뼈대만 인터페이스로 만듦.
 */
public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
