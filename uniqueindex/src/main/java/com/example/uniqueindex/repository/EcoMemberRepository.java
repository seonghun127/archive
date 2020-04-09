package com.example.uniqueindex.repository;

import com.example.uniqueindex.entity.EcoMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EcoMemberRepository extends JpaRepository<EcoMember, Long> {
}
