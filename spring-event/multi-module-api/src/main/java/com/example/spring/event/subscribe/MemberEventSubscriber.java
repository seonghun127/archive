package com.example.spring.event.subscribe;

import com.example.spring.event.MemberEvent;
import com.example.spring.event.service.MemberIncreaseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
@Component
@RequiredArgsConstructor
public class MemberEventSubscriber {

    private final MemberIncreaseService memberIncreaseService;

//    @TransactionalEventListener(condition = "#memberEvent.member.count >= 100")
    @TransactionalEventListener(condition = "#root.args[0].member.count >= 100")
    public void processEvent(MemberEvent memberEvent) {
        log.info("Event received! {}", memberEvent.toString());
        memberIncreaseService.increase(memberEvent.getMember());
    }
}
