package com.example.choiceculture.domain.festival.repository.querydsl;

import com.example.choiceculture.domain.festival.dto.FestivalRequestDTO;
import com.example.choiceculture.domain.festival.entity.FestivalInfo;

import java.util.List;

public interface FestivalInfoRepositoryCustom {
    List<FestivalInfo> findByDTO(FestivalRequestDTO requestDTO);
}
