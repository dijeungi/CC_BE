package com.example.choiceculture.domain.festival.repository;

import com.example.choiceculture.domain.festival.dto.FestivalProjection;
import com.example.choiceculture.domain.festival.dto.FestivalResponseDTO;
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

    @Query(value = "select f from FestivalInfo f order by f.ranking")
    List<FestivalInfo> findByRanking();

    @Query(value = "select f from FestivalInfo f where f.categoryId=:userFavorite1 order by f.ranking")
    List<FestivalInfo> findRankingByUserId(@Param("userFavorite1") String userFavorite1);

    @Query(value = "select f from FestivalInfo f where f.categoryId=:userFavorite1 order by f.ranking limit 10")
    List<FestivalInfo> findByFavorite(@Param("userFavorite1") String userFavorite1);

    @Query(value = "select f.id as festivalId, f.festivalName as festivalName from FestivalInfo f")
    List<FestivalProjection> getIdList();

    @Query("select f from FestivalInfo f where f.festivalName like concat('%', :keyword, '%') ")
    List<FestivalInfo> findByFestivalKeyword(@Param("keyword") String keyword);
}
