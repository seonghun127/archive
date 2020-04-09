package com.example.springevent.publish.event;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberEvent {

    private Long id;

    @Builder
    public MemberEvent(Long id) {
        this.id = id;
    }
}
