package com.example.springevent.service;

import com.example.springevent.entity.Member;
import com.example.springevent.entity.MemberRepository;
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
        log.info("MemberService.increase is called!");
        member.increase();
        return memberRepository.save(member);
    }
}
