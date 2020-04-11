package com.example.springevent.subscribe;

import com.example.springevent.service.event.MemberEvent;
import com.example.springevent.service.MemberIncreaseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
@Component
@RequiredArgsConstructor
public class MemberEventSubscriber {

    private final MemberIncreaseService memberIncreaseService;

    @TransactionalEventListener
    public void processEvent(MemberEvent memberEvent) {
        log.info("Event received! {}", memberEvent.toString());
        memberIncreaseService.increase(memberEvent.getMember());
    }
}
