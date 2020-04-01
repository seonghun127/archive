package com.example.springpractice.redis.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Getter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String memberNo;

    private Integer count;

    @Builder
    public Member(String memberNo, Integer count) {
        this.memberNo = memberNo;
        this.count = count;
    }

    public Integer increment() {
        return ++count;
    }

    public Integer decrement() {
        return --count;
    }
}
