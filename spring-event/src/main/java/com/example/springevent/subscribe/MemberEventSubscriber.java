package com.example.springevent.subscribe;

import com.example.springevent.publish.event.MemberEvent;
import com.example.springevent.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class MemberEventSubscriber {

    private final MemberService memberService;

    @EventListener
    public void processEvent(MemberEvent memberEvent) {
        memberService.increase(memberEvent.getId());
    }
}
