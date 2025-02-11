package com.example.choiceculture.domain.festival.repository;

import com.example.choiceculture.domain.festival.entity.FestivalInfo;
import com.example.choiceculture.domain.festival.repository.querydsl.FestivalInfoRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FestivalInfoRepository extends JpaRepository<FestivalInfo, Integer>, FestivalInfoRepositoryCustom {
    @Query(value = "select f from FestivalInfo f where f.fromDate>=now() order by f.fromDate")
    List<FestivalInfo> findByFromDate();

    @Query("select f from FestivalInfo f where f.festivalName like concat('%', :searchKeyword, '%') " +
            "OR f.placeName like concat('%', :searchKeyword, '%') ")
    List<FestivalInfo> findBySearchKeyword(@Param("searchKeyword") String searchKeyword);
}
