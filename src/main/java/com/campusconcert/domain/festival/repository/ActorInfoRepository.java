package com.campusconcert.domain.festival.repository;

import com.campusconcert.domain.festival.entity.ActorInfo;
import com.campusconcert.domain.festival.repository.querydsl.ActorInfoRepositoryCustom;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ActorInfoRepository extends JpaRepository<ActorInfo, Integer>, ActorInfoRepositoryCustom {
    @Query("select a from ActorInfo a where a.actorName like concat('%', :searchKeyword, '%')")
    List<ActorInfo> findBySearchKeyword(@Param("searchKeyword") String searchKeyword);

    List<ActorInfo> findByFestivalId(@NotNull Integer festivalId);

    @Query("select a from ActorInfo a where a.actorName like concat('%', :keyword, '%') ")
    List<ActorInfo> findByActorKeyword(String keyword);
}
