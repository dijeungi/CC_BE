package com.example.choiceculture.domain.festival.repository.querydsl;

import com.example.choiceculture.domain.festival.dto.FestivalInfoDTO;
import com.example.choiceculture.domain.festival.dto.FestivalRequestDTO;
import com.example.choiceculture.domain.festival.entity.FestivalInfo;

import java.util.List;

public interface FestivalInfoRepositoryCustom {
    FestivalInfoDTO findByFestivalId(Integer festivalId);

    List<FestivalInfo> findByDTO(FestivalRequestDTO requestDTO);

    List<FestivalInfoDTO> findByRanking();
  
    List<FestivalInfo> findByDTOCategory(FestivalRequestDTO requestDTO);
  
}
