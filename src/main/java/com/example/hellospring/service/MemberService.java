package com.example.hellospring.service;

import com.example.hellospring.domain.Member;
import com.example.hellospring.repository.MemberRepository;
import com.example.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

// 회원 관리 Service
// cmd + shift + T >> test class를 만들어줌..!
public class MemberService {

    private final MemberRepository memberRepository;

    // 직접사용하는 것이 아닌 외부에서 객체를 넣어줌
    // 의존성 주입!
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // Sign Up
    public Long join(Member member){
        // 중복확인
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    // control + T >> Extract Method 검색하면 기존의 코드를 메소드화 시켜줌.
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m ->{ // Optional객체의 메소드
                    throw new IllegalStateException("already exit member.");
                });
    }

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }

}
