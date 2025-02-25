package com.campusconcert.domain.festival.repository.querydsl;

import com.campusconcert.domain.festival.dto.FestivalInfoDTO;
import com.campusconcert.domain.festival.dto.FestivalRequestDTO;
import com.campusconcert.domain.festival.entity.FestivalInfo;

import java.util.List;

public interface FestivalInfoRepositoryCustom {
    FestivalInfoDTO findByFestivalId(Integer festivalId);

    List<FestivalInfo> findByDTO(FestivalRequestDTO requestDTO);

    List<FestivalInfoDTO> findByRanking();
  
    List<FestivalInfo> findByDTOCategory(FestivalRequestDTO requestDTO);
  
}
