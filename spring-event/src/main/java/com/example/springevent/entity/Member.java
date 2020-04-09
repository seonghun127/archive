package com.example.springevent.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    public int count;

    @Builder
    public Member(int count) {
        this.count = count;
    }

    public int increase() {
        return ++count;
    }
}
