package com.example.springpractice;

import com.example.springpractice.redis.cache.MemberCacheStore;
import com.example.springpractice.redis.entity.Member;
import com.example.springpractice.redis.entity.MemberRepository;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SpringPracticeApplicationTests {

	private static final Logger log = LoggerFactory.getLogger(SpringPracticeApplication.class);

	@Autowired
	private MemberRepository memberRepository;

	@Autowired
	private MemberCacheStore memberCacheStore;

	@Test
	void redis_저장_조회_테스트() {
		// 1. Given
		Member member = Member.builder()
				.memberNo("123")
				.count(100)
				.build();
		Member newMember = memberRepository.save(member);

		// 2. When
		memberCacheStore.set(newMember.getMemberNo(), newMember);

		// 3. Then
		assertThat(memberCacheStore.get("123")).isEqualTo(newMember);
	}
}
