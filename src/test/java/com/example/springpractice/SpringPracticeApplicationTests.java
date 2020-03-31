package com.example.springpractice;

import com.example.springpractice.entity.EcoMember;
import com.example.springpractice.repository.EcoMemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringPracticeApplicationTests {

	@Autowired
	private EcoMemberRepository ecoMemberRepository;

	@Test
	void 유니크_제약조건_테스트() {
		// 1. Given
		String memberNo = "123";
		EcoMember ecoMember1 = EcoMember.builder()
				.memberNo(memberNo)
				.count(123)
				.build();
		EcoMember ecoMember2 = EcoMember.builder()
				.memberNo(memberNo)
				.count(123)
				.build();

		// 2. When
		ecoMemberRepository.save(ecoMember1);
		ecoMemberRepository.save(ecoMember2);		// 유니크 제약 조건이 발생하는 지점

		// 3. Then
	}
}
