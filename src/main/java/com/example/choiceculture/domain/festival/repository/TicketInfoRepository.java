package com.example.choiceculture.domain.festival.repository;

import com.example.choiceculture.domain.festival.entity.TicketInfo;
import com.example.choiceculture.domain.festival.repository.querydsl.TicketInfoRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TicketInfoRepository extends JpaRepository<TicketInfo, String>, TicketInfoRepositoryCustom {
    @Query(value = "select t.locationNum from TicketInfo t where t.festivalId=:festivalId and t.dateId=:dateId and t.refundState='YET'")
    List<String> findByFestivalIdAndDateId(@Param("festivalId") Integer festivalId, @Param("dateId") Integer dateId);
}
