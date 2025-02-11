package com.example.choiceculture.domain.festival.repository;

import com.example.choiceculture.domain.festival.entity.FestivalInfo;
import com.example.choiceculture.domain.festival.repository.querydsl.FestivalInfoRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FestivalInfoRepository extends JpaRepository<FestivalInfo, Integer>, FestivalInfoRepositoryCustom {
    @Query(value = "select f from FestivalInfo f where f.fromDate>=now() order by f.fromDate")
    List<FestivalInfo> findByFromDate();
}
