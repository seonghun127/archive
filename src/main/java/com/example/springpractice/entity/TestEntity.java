package com.example.springpractice.entity;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@EqualsAndHashCode
public class TestEntity {

    private String value;

    @Builder
    public TestEntity(String value) {
        this.value = value;
    }
}
