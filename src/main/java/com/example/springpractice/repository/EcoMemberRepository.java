package com.example.springpractice.repository;

import com.example.springpractice.entity.EcoMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EcoMemberRepository extends JpaRepository<EcoMember, Long> {
}
