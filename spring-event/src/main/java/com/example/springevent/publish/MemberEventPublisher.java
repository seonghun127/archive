package com.example.springevent.publish;

import com.example.springevent.publish.event.MemberEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class MemberEventPublisher {

    private final ApplicationEventPublisher applicationEventPublisher;

    public void publish(Long id) {
        applicationEventPublisher.publishEvent(MemberEvent.builder()
                .id(id)
                .build());
        log.info("publish event!!");
    }
}
