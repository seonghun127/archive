package com.example.spring.event.service;

import com.example.spring.event.MemberEvent;
import com.example.spring.event.entity.Member;
import com.example.spring.event.entity.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberEventService {

    private final MemberRepository memberRepository;
    private final ApplicationEventPublisher applicationEventPublisher;

    @Transactional
    public void save() {
        Member member = memberRepository.save(Member.builder()
                .count(100)
                .build());

        publishEvent(member);
    }

    @Transactional
    public void saveBy(int count) {
        Member member = memberRepository.save(Member.builder()
                .count(count)
                .build());

        publishEvent(member);
    }

    private void publishEvent(Member member) {
        applicationEventPublisher.publishEvent(MemberEvent.builder()
                .id(member.getId())
                .member(member)
                .build());
        log.info("Event is published!");
    }
}
