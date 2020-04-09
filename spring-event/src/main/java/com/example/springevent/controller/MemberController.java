package com.example.springevent.controller;

import com.example.springevent.publish.MemberEventPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberEventPublisher memberEventPublisher;

    @GetMapping("/{memberId}")
    public void publishEvent(@PathVariable Long memberId) {
        memberEventPublisher.publish(memberId);
    }
}
