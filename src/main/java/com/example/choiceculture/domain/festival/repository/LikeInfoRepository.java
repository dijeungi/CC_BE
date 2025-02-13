package com.example.choiceculture.domain.festival.repository;

import com.example.choiceculture.domain.festival.entity.LikeInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface LikeInfoRepository extends JpaRepository<LikeInfo, Integer> {
    @Query(value = "select l from LikeInfo l where l.memberId=:userId and l.festivalId=:festivalId")
    Optional<LikeInfo> findByDTO(String userId, Integer festivalId);
}
