package com.example.spring.event;

import com.example.spring.event.entity.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class MemberEvent {

    private Long id;
    private Member member;

    @Builder
    public MemberEvent(Long id, Member member) {
        this.id = id;
        this.member = member;
    }
}
