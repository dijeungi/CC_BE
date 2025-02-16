package com.example.choiceculture.domain.member.repository;

import com.example.choiceculture.domain.member.entity.Member;
import com.example.choiceculture.domain.member.repository.querydsl.MemberRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, String>
        , MemberRepositoryCustom {


    @Query("select u from Member u where u.email = :email")
        // leftjoin + fetch join (한번에 조회 ) Pagination OOM ->
    Optional<Member> findByEmail(@Param("email") String email);

    @Query("select u from Member u where u.id = :id")
        // leftjoin + fetch join (한번에 조회 ) Pagination OOM ->
    Optional<Member> findById(@Param("id") String id);


    @Query("select u from Member u where u.userPhone = :phoneNumber")
    Optional<Member> findByUserPhone(@Param("phoneNumber") String phoneNumber);


}
