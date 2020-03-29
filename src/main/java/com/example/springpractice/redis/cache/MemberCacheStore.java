package com.example.springpractice.redis.cache;

import com.example.springpractice.redis.entity.Member;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

@Component
public class MemberCacheStore {

    private RedisTemplate<String, Object> redisTemplate;
    private ValueOperations<String, Object> valueOperations;

    public MemberCacheStore(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.valueOperations = redisTemplate.opsForValue();
    }

    public Member get(String key) {
        return (Member) valueOperations.get(key);
    }

    public void set(String key, Object value) {
        valueOperations.set(key, value);
    }
}
