package com.example.springpractice.redis.controller;

import com.example.springpractice.redis.entity.Member;
import com.example.springpractice.redis.service.MemberService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/{memberNo}")
    public Member find(@PathVariable String memberNo) {
        return memberService.find(memberNo);
    }
}
