package com.example.uniqueindex.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(
        name = "eco_member",
        indexes = {
                @Index(name = "ik_eco_member_id", columnList = "id"),
                @Index(name = "ik_eco_member_member_no", columnList = "memberNo")
        }
        ,
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_eco_member_member_no", columnNames = {"memberNo"})
        }
)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class EcoMember {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true, nullable = false, length = 12)
    private String memberNo;

    @Column(nullable = false)
    private Integer count;

    @Builder
    public EcoMember(String memberNo, Integer count) {
        this.memberNo = memberNo;
        this.count = count;
    }
}
