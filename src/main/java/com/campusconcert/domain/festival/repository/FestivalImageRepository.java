package com.campusconcert.domain.festival.repository;

import com.campusconcert.domain.festival.entity.FestivalImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FestivalImageRepository extends JpaRepository<FestivalImage, Integer> {
    FestivalImage findByFestivalId(Integer festivalId);
}
