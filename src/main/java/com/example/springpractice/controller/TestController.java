package com.example.springpractice.controller;

import com.example.springpractice.entity.TestEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/")
    public String index(@RequestBody TestEntity testEntity) {
        return testEntity.getValue();
    }
}
