package com.example.spring.event.service;

import com.example.spring.event.entity.MemberRepository;
import com.example.spring.event.entity.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberIncreaseService {

    private final MemberRepository memberRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Member increase(Member member) {
        log.info("MemberIncreaseService.increase is called!");
        member.increase();
        return memberRepository.save(member);
    }
}
