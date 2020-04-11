package com.example.springevent.controller;

import com.example.springevent.service.MemberEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberEventService memberEventService;

    @GetMapping()
    public void publishEvent() {
        memberEventService.save();
    }
}
