package com.example.springevent.service;

import com.example.springevent.entity.Member;
import com.example.springevent.entity.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Member increase(Long id) {
        log.info("MemberService.increase is called!");
        Member member = memberRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        member.increase();
        return member;
    }
}
