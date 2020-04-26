package com.example.spring.event.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
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
