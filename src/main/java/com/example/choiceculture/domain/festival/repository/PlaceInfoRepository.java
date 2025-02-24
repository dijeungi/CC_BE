package com.example.choiceculture.domain.festival.repository;

import com.example.choiceculture.domain.festival.entity.PlaceInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceInfoRepository extends JpaRepository<PlaceInfo, Integer> {
    PlaceInfo findByFestivalId(Integer festivalId);
}
