package com.example.choiceculture.domain.festival.repository;

import com.example.choiceculture.domain.festival.entity.FestivalTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FestivalTimeRepository extends JpaRepository<FestivalTime, Integer> {
    @Query(value = "select t from FestivalTime t where t.festivalInfo.id=:festivalId")
    List<FestivalTime> findByFestivalId(@Param("festivalId") Integer festivalId);
}
