package com.example.spring.event.controller;


import com.example.spring.event.service.MemberEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberEventService memberEventService;

    @GetMapping
    public void publishEvent() {
        memberEventService.save();
    }

    @GetMapping("/members/{count}")
    public void publishMemberEvent(@PathVariable int count) {
        memberEventService.saveBy(count);
    }
}
