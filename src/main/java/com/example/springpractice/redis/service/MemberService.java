package com.example.springpractice.redis.service;

import com.example.springpractice.redis.cache.MemberCacheStore;
import com.example.springpractice.redis.entity.Member;
import com.example.springpractice.redis.entity.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;
    private final MemberCacheStore memberCacheStore;

    public MemberService(MemberRepository memberRepository, MemberCacheStore memberCacheStore) {
        this.memberRepository = memberRepository;
        this.memberCacheStore = memberCacheStore;
    }

    public Member find(String memberNo) {
         Member member = memberCacheStore.get(memberNo);
         if (member != null) {
             return member;
         }
         Member findedMember = memberRepository.findByMemberNo(memberNo).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
         memberCacheStore.set(findedMember.getMemberNo(), findedMember);
         return findedMember;
    }
}
