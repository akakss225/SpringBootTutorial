package com.example.hellospring.repository;

import com.example.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    // JPQL select m from member m where m.name = ?
    // 즉, 인터페이스 메소드만으로 JPQL을 다 짜줌...
    @Override
    Optional<Member> findByName(String name);
}
