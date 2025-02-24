package com.example.choiceculture.domain.festival.repository;

import com.example.choiceculture.domain.festival.entity.FestivalInfoAccess;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FestivalInfoAccessRepository extends JpaRepository<FestivalInfoAccess, Integer> {
    @Query("select a from FestivalInfoAccess a where a.festival.festivalName like concat('%', :searchTerm, '%') ")
    Page<FestivalInfoAccess> findByFestivalNameContainingIgnoreCase(@Param("searchTerm") String searchTerm, Pageable pageable);

}
