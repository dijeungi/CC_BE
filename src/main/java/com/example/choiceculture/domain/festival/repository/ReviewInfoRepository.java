package com.example.choiceculture.domain.festival.repository;

import com.example.choiceculture.domain.festival.entity.ReviewInfo;
import com.example.choiceculture.domain.festival.enums.ReviewType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewInfoRepository extends JpaRepository<ReviewInfo, String> {
    List<ReviewInfo> findByType(ReviewType type);
}
